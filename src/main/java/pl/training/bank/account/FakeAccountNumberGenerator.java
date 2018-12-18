package pl.training.bank.account;

import org.springframework.stereotype.Service;

@Service("fakeAccountNumberGenerator")
public class FakeAccountNumberGenerator implements AccountNumberGenerator {

    private static final String ACCOUNT_NUMBER = "00000000000000000000000001";

    @Override
    public String next() {
        return ACCOUNT_NUMBER;
    }

}
