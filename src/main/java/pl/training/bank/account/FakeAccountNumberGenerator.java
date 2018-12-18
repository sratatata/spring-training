package pl.training.bank.account;

public class FakeAccountNumberGenerator implements AccountNumberGenerator {

    private static final String ACCOUNT_NUMBER = "00000000000000000000000001";

    @Override
    public String next() {
        return ACCOUNT_NUMBER;
    }

}
