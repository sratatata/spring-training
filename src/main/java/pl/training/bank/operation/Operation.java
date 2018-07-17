package pl.training.bank.operation;

import pl.training.bank.account.Account;

public interface Operation {

    String getName();

    void execute(Account account, long funds);

    default boolean hasName(String name) {
        return getName().equals(name);
    }

}
