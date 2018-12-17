package pl.training.bank.operation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Set;

@Configuration
public class OperationConfig {

    @Bean
    public Deposit deposit() {
        return new Deposit();
    }

    @Bean
    public Withdraw withdraw() {
        return new Withdraw();
    }

    @Bean
    public OperationService operationService(Set<Operation> operations) {
        return new OperationService(operations);
    }

}
