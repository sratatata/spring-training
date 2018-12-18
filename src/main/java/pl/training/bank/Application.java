package pl.training.bank;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.training.bank.account.*;
import pl.training.bank.common.ResultPage;
import pl.training.bank.common.ValidatorService;
import pl.training.bank.disposition.Disposition;
import pl.training.bank.disposition.DispositionService;
import pl.training.bank.operation.Deposit;
import pl.training.bank.operation.OperationService;
import pl.training.bank.operation.Withdraw;

import javax.validation.Validation;
import javax.validation.Validator;

public class Application {

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("pl.training.bank")) {
            AccountService accountService = applicationContext.getBean(AccountService.class);
            DispositionService dispositionService = applicationContext.getBean(DispositionService.class);

            Account account = accountService.create();

            Disposition deposit = new Disposition(account.getNumber(), 0, "deposit");
            Disposition withdraw = new Disposition(account.getNumber(), 500, "withdraw");
            dispositionService.process(deposit);
            dispositionService.process(withdraw);

            ResultPage<Account> resultPage = accountService.get(0, 10);
            resultPage.getData().forEach(System.out::println);
        }
    }

}
