package pl.training.bank.account;

import lombok.Setter;
import org.springframework.stereotype.Repository;
import pl.training.bank.common.ResultPage;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@Repository("accountRepository")
public class HashMapAccountRepository implements AccountRepository {

    @Setter
    private Map<String, Account> accounts = new LinkedHashMap<>();
    private long counter;

    @Override
    public synchronized Account save(Account account) {
        account.setId(++counter);
        accounts.put(account.getNumber(), account);
        return account;
    }

    @Override
    public synchronized ResultPage<Account> get(int pageNumber, int pageSize) {
        return new ResultPage<>(new ArrayList<>(accounts.values()));
    }

    @Override
    public synchronized Optional<Account> getBy(String accountNumber) {
        return Optional.ofNullable(accounts.get(accountNumber));
    }

    @Override
    public synchronized void update(Account account) {
        accounts.replace(account.getNumber(), account);
    }

}
