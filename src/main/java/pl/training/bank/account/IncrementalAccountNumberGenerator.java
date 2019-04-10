package pl.training.bank.account;

import java.util.concurrent.atomic.AtomicLong;

import static java.lang.Long.parseLong;

public class IncrementalAccountNumberGenerator implements AccountNumberGenerator {

    private static final String ACCOUNT_NUMBER_FORMAT = "%026d";

    private AtomicLong counter = new AtomicLong();

    public IncrementalAccountNumberGenerator(AccountRepository accountRepository) {
        String lastAccountNumber = accountRepository.getLastAccountNumber();
        if (lastAccountNumber != null) {
            counter = new AtomicLong(parseLong(lastAccountNumber));
        }
    }

    @Override
    public String next() {
        return String.format(ACCOUNT_NUMBER_FORMAT, counter.incrementAndGet());
    }

}
