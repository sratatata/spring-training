package pl.training.bank;

import pl.training.bank.account.*;
import pl.training.bank.common.ResultPage;
import pl.training.bank.disposition.Disposition;
import pl.training.bank.disposition.DispositionService;
import pl.training.bank.operation.Deposit;
import pl.training.bank.operation.OperationService;
import pl.training.bank.operation.Withdraw;

public class Application {

    public static void main(String[] args) {
        AccountRepository accountRepository = new HashMapAccountRepository();
        AccountNumberGenerator accountNumberGenerator = new IncrementalAccountNumberGenerator();
        AccountService accountService = new AccountService(accountNumberGenerator, accountRepository);

        OperationService operationService = new OperationService();
        operationService.add(new Deposit(), new Withdraw());

        DispositionService dispositionService = new DispositionService(accountService, operationService);

        Account account = accountService.create();

        Disposition deposit = new Disposition(account.getNumber(), 1_000, "deposit");
        Disposition withdraw = new Disposition(account.getNumber(), 500, "withdraw");
        dispositionService.process(deposit, withdraw);

        ResultPage<Account> resultPage = accountService.get(0, 10);
        resultPage.getData().forEach(System.out::println);
    }

}
