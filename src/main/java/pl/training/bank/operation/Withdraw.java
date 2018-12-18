package pl.training.bank.operation;

import org.springframework.stereotype.Service;
import pl.training.bank.account.Account;

@Service
public class Withdraw implements Operation {

    @Override
    public void execute(Account account, long funds) {
        if (account.getBalance() < funds) {
            throw new InsufficientFundsException();
        }
        account.withdraw(funds);
    }

}
