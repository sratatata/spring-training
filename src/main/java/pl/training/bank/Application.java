package pl.training.bank;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.training.bank.account.Account;
import pl.training.bank.account.AccountService;
import pl.training.bank.common.ResultPage;
import pl.training.bank.disposition.Disposition;
import pl.training.bank.disposition.DispositionService;

public class Application {

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("pl.training.bank")) {
            AccountService accountService = applicationContext.getBean(AccountService.class);
            DispositionService dispositionService = applicationContext.getBean(DispositionService.class);

            Account account = accountService.create();

            Disposition deposit = new Disposition(account.getNumber(), 50_001, "deposit");
            Disposition withdraw = new Disposition(account.getNumber(), 500, "withdraw");
            dispositionService.process(deposit);
            dispositionService.process(withdraw);

            ResultPage<Account> resultPage = accountService.get(0, 10);
            resultPage.getData().forEach(System.out::println);
        }
    }

}
