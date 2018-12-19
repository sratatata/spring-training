package pl.training.bank.account;

import javax.persistence.EntityManagerFactory;

public class JpaIncrementalAccountNumberGenerator extends IncrementalAccountNumberGenerator {

    private static final String SELECT_LAST_ACCOUNT_NUMBER = "select max(a.number) from Account a";

    public JpaIncrementalAccountNumberGenerator(EntityManagerFactory entityManagerFactory) {
        String lastAccountNumber = entityManagerFactory.createEntityManager()
                .createQuery(SELECT_LAST_ACCOUNT_NUMBER, String.class)
                .getSingleResult();
        setCurrentAccountNumber(lastAccountNumber);
    }

}
