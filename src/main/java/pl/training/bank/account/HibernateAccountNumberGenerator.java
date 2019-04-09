package pl.training.bank.account;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class HibernateAccountNumberGenerator extends IncrementalAccountNumberGenerator {

    private static final String SELECT_LAST_ACCOUNT_NUMBER = "select max(a.number) from Account a";

    public HibernateAccountNumberGenerator(SessionFactory sessionFactory) {
        try (Session session = sessionFactory.openSession()) {
            session.createQuery(SELECT_LAST_ACCOUNT_NUMBER, String.class)
                    .uniqueResultOptional()
                    .ifPresent(this::setCurrentAccountNumber);
        }
    }

}
