package pl.training.bank.operation;

import pl.training.bank.account.Account;

public class DepositOperation implements Operation {

    @Override
    public String getName() {
        return OperationName.DEPOSIT.name();
    }

    @Override
    public void execute(Account account, long funds) {
        account.deposit(funds);
    }

}
