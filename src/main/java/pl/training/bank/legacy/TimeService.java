package pl.training.bank.legacy;

import javax.ejb.Stateless;

@Stateless
public class TimeService {

    public long getTime() {
        return System.currentTimeMillis();
    }

}
