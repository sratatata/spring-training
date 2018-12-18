package pl.training.bank.account;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountsListExtractor implements ResultSetExtractor<List<Account>> {

    private AccountExtractor accountExtractor = new AccountExtractor();

    @Override
    public List<Account> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        List<Account> accounts = new ArrayList<>();
        while (resultSet.next()) {
            accountExtractor.extract(resultSet).ifPresent(accounts::add);
        }
        return accounts;
    }

}
