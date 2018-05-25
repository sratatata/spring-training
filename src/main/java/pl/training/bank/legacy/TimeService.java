package pl.training.bank.legacy;

import javax.ejb.Local;

@Local
public interface TimeService {

    long getTime();

}
