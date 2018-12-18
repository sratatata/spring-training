package pl.training.bank.account;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class JdbcTemplateIncrementalAccountNumberGenerator extends IncrementalAccountNumberGenerator {

    private static final String SELECT_LAST_ACCOUNT_NUMBER = "select max(account_number) from account";

    public JdbcTemplateIncrementalAccountNumberGenerator(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String lastAccountNumber = jdbcTemplate.queryForObject(SELECT_LAST_ACCOUNT_NUMBER, String.class);
        setCurrentAccountNumber(lastAccountNumber);
    }

}
