package pl.training.bank.operation;

import pl.training.bank.account.Account;

public interface Operation {

    String OPERATION_NAME_SUFFIX = "Operation";

    void execute(Account account, long funds);

    default boolean hasName(String name) {
        String className = getClass().getSimpleName();
        String operationName = className.replaceFirst(OPERATION_NAME_SUFFIX, "").toUpperCase();
        return operationName.equals(name);
    }

}
