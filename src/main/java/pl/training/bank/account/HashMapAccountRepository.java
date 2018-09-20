package pl.training.bank.account;

import lombok.Setter;
import pl.training.bank.common.ResultPage;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class HashMapAccountRepository implements AccountRepository {

    @Setter
    private Map<String, Account> accounts = new LinkedHashMap<>();
    private AtomicLong counter = new AtomicLong();

    @Override
    public Account save(Account account) {
        account.setId(counter.incrementAndGet());
        accounts.put(account.getNumber(), account);
        return account;
    }

    @Override
    public ResultPage<Account> get(int pageNumber, int pageSize) {
        return new ResultPage<>(new ArrayList<>(accounts.values()));
    }

    @Override
    public Optional<Account> get(String accountNumber) {
        return Optional.ofNullable(accounts.get(accountNumber));
    }

    @Override
    public void update(Account account) {
        accounts.replace(account.getNumber(), account);
    }

}
