package pl.training.bank.operation;

import pl.training.bank.account.Account;

public interface Operation {

   void execute(Account account, long funds);

    default boolean nameEquals(String name) {
        String operationName = getClass().getSimpleName().toLowerCase();
        return operationName.equals(name);
    }

}
