package pl.training.bank.operation;

import org.springframework.stereotype.Service;
import pl.training.bank.account.Account;

@Service
public class Deposit implements Operation {

   @Override
    public void execute(Account account, long funds) {
        account.deposit(funds);
    }

}
