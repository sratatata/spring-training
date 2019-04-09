package pl.training.bank.account;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccountConfig {

    @Bean
    public AccountRepository accountRepository(SessionFactory sessionFactory) {
        return new HibernateAccountRepository(sessionFactory);
    }

    @Bean
    public AccountNumberGenerator accountNumberGenerator(SessionFactory sessionFactory) {
        return new HibernateAccountNumberGenerator(sessionFactory);
    }

    @Bean
    public AccountService accountService(AccountNumberGenerator accountNumberGenerator, AccountRepository accountRepository) {
        return new AccountService(accountNumberGenerator, accountRepository);
    }

}