package pl.training.bank;

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
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        ValidatorService validatorService = new ValidatorService(validator);

        AccountRepository accountRepository = new HashMapAccountRepository();
        AccountNumberGenerator accountNumberGenerator = new IncrementalAccountNumberGenerator();
        AccountService accountService = new AccountService(accountNumberGenerator, accountRepository);

        OperationService operationService = new OperationService();
        operationService.add(new Deposit());
        operationService.add(new Withdraw());

        DispositionService dispositionService = new DispositionService(accountService, operationService, validatorService);

        Account account = accountService.create();
        dispositionService.process(
                new Disposition(account.getNumber(), 1_000, "deposit"),
                new Disposition(account.getNumber(), 500, "withdraw")
        );

        ResultPage<Account> resultPage = accountService.get(0, 10);
        resultPage.getData().forEach(System.out::println);
    }

}
