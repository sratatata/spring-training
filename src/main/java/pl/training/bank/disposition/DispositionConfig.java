package pl.training.bank.disposition;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import pl.training.bank.account.AccountService;
import pl.training.bank.operation.OperationService;

import javax.sql.DataSource;

@Configuration
public class DispositionConfig {

    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public DispositionService dispositionService(AccountService accountService, OperationService operationService) {
        return new DispositionService(accountService, operationService);
    }

    @Bean
    public DispositionLogger dispositionLogger() {
        return new DispositionLogger();
    }

    @Bean
    public LargeDepositLogger largeDepositLogger() {
        return new LargeDepositLogger();
    }

    @Bean
    public LargeDepositListener largeDepositListener() {
        return new LargeDepositListener();
    }

    @Bean
    public ExecutedDispositionRepository executedDispositionRepository(SessionFactory sessionFactory) {
        return new HibernateExecutedDispositionRepository(sessionFactory);
    }

    @Bean
    public ExecutedDispositionLogger executedDispositionLogger(ExecutedDispositionRepository executedDispositionRepository) {
        return new ExecutedDispositionLogger(executedDispositionRepository);
    }

}