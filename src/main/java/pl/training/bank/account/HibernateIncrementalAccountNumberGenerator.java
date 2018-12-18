package pl.training.bank.account;

import org.hibernate.SessionFactory;

public class HibernateIncrementalAccountNumberGenerator extends IncrementalAccountNumberGenerator {

    private static final String SELECT_LAST_ACCOUNT_NUMBER = "select max(a.number) from Account a";

    public HibernateIncrementalAccountNumberGenerator(SessionFactory sessionFactory) {
        sessionFactory.openSession().createQuery(SELECT_LAST_ACCOUNT_NUMBER, String.class)
                .uniqueResultOptional()
                .ifPresent(this::setCurrentAccountNumber);
    }

}
