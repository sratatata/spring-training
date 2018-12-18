package pl.training.bank.disposition;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

public class JdbcExecutedDispositionRepository implements ExecutedDispositionRepository {

    private static final String INSERT_DISPOSITION = "insert into disposition (account_number,funds,operation_timestamp,operation_type) values (:accountNumber,:funds,:timestamp,:operationType)";

    private NamedParameterJdbcTemplate jdbcTemplate;

    public JdbcExecutedDispositionRepository(DataSource dataSource) {
        jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public void save(ExecutedDisposition executedDisposition) {
        jdbcTemplate.update(INSERT_DISPOSITION, new BeanPropertySqlParameterSource(executedDisposition));
    }

}
