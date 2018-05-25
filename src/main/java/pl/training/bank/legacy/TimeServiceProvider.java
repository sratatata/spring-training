package pl.training.bank.legacy;

import javax.ejb.Stateless;

@Stateless
public class TimeServiceProvider implements TimeService {

    @Override
    public long getTime() {
        return System.currentTimeMillis();
    }

}
