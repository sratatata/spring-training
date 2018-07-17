package pl.training.bank;

import pl.training.bank.account.*;
import pl.training.bank.common.ResultPage;
import pl.training.bank.common.ValidatorService;
import pl.training.bank.disposition.Disposition;
import pl.training.bank.disposition.DispositionService;
import pl.training.bank.operation.DepositOperation;
import pl.training.bank.operation.OperationService;
import pl.training.bank.operation.WithdrawOperation;

import javax.validation.Validation;
import javax.validation.Validator;

import static pl.training.bank.operation.OperationName.DEPOSIT;
import static pl.training.bank.operation.OperationName.WITHDRAW;

public class Application {

    public static void main(String[] args) {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        ValidatorService validatorService = new ValidatorService(validator);

        AccountRepository accountRepository = new HashMapAccountRepository();
        AccountNumberGenerator accountNumberGenerator = new IncrementalAccountNumberGenerator();
        AccountService accountService = new AccountService(accountNumberGenerator, accountRepository);

        OperationService operationService = new OperationService();
        operationService.add(new DepositOperation());
        operationService.add(new WithdrawOperation());

        DispositionService dispositionService = new DispositionService(accountService, operationService, validatorService);

        Account account = accountService.create();
        dispositionService.process(
                new Disposition(account.getNumber(), 1_000, DEPOSIT),
                new Disposition(account.getNumber(), 500, WITHDRAW)
        );

        ResultPage<Account> resultPage = accountService.get(0, 10);
        resultPage.getData().forEach(System.out::println);
    }

}
