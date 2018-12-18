package pl.training.bank.disposition;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import pl.training.bank.account.AccountService;
import pl.training.bank.common.ValidatorService;
import pl.training.bank.operation.OperationService;

@Configuration
public class DispositionConfig {

    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public DispositionService dispositionService(AccountService accountService, OperationService operationService, ValidatorService validatorService) {
        return new DispositionService(accountService, operationService, validatorService);
    }

}
