package pl.training.bank.account;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import pl.training.bank.common.ResultPage;

@RequiredArgsConstructor
public class AccountService {

    @NonNull
    private AccountNumberGenerator accountNumberGenerator;
    @NonNull
    private AccountRepository accountRepository;

    public Account create() {
        String accountNumber = accountNumberGenerator.next();
        Account account = new Account(accountNumber);
        return accountRepository.save(account);
    }

    public Account getBy(String accountNumber) {
        return accountRepository.getBy(accountNumber)
                .orElseThrow(AccountNotFoundException::new);
    }

    public ResultPage<Account> get(int pageNumber, int pageSize) {
        return accountRepository.get(pageNumber, pageSize);
    }

    public void update(Account account) {
        getBy(account.getNumber());
        accountRepository.update(account);
    }

}
