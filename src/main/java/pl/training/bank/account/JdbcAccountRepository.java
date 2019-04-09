package pl.training.bank.account;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import pl.training.bank.common.ResultPage;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class JdbcAccountRepository implements AccountRepository {

    private static final String INSERT_ACCOUNT = "insert into account (account_number,balance) values (:number,:balance)";
    private static final String UPDATE_ACCOUNT = "update account set balance = :balance where id = :id";
    private static final String SELECT_ACCOUNT_BY_NUMBER = "select * from account where account_number = :number";
    private static final String SELECT_ACCOUNTS = "select * from account offset :offset limit :limit";
    private static final int NO_RESULTS = 0;

    private NamedParameterJdbcTemplate jdbcTemplate;
    private AccountExtractor accountExtractor = new AccountExtractor();
    private AccountListExtractor accountListExtractor = new AccountListExtractor();

    public JdbcAccountRepository(DataSource dataSource) {
        jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public Account save(Account account) {
        SimpleKeyHolder keyHolder = new SimpleKeyHolder();
        jdbcTemplate.update(INSERT_ACCOUNT, new BeanPropertySqlParameterSource(account), keyHolder);
        keyHolder.getId().ifPresent(account::setId);
        return account;
    }

    @Override
    public ResultPage<Account> get(int pageNumber, int pageSize) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("offset", pageNumber * pageSize)
                .addValue("limit", pageSize);
        List<Account> accounts = jdbcTemplate.query(SELECT_ACCOUNTS, parameterSource, accountListExtractor);
        return new ResultPage<>(accounts, pageNumber, -1);
    }

    @Override
    public Optional<Account> getByNumber(String accountNumber) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource("number", accountNumber);
        return jdbcTemplate.query(SELECT_ACCOUNT_BY_NUMBER, parameterSource, accountExtractor);
    }

    @Override
    public void update(Account account) {
        if (NO_RESULTS == jdbcTemplate.update(UPDATE_ACCOUNT, new BeanPropertySqlParameterSource(account))) {
            throw new AccountNotFoundException();
        }
    }

}
