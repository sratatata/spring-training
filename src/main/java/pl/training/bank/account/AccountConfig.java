package pl.training.bank.account;

import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.EntityManagerFactory;

@Configuration
public class AccountConfig {

    @Bean
    public AccountNumberGenerator accountNumberGenerator(EntityManagerFactory entityManagerFactory) {
        return new JpaIncrementalAccountNumberGenerator(entityManagerFactory);
    }

    @Bean
    public AccountService accountService(AccountNumberGenerator accountNumberGenerator, AccountRepository accountRepository) {
        return new AccountService(accountNumberGenerator, accountRepository);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(15);
    }

}
