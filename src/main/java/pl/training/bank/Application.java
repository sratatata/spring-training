package pl.training.bank;

import pl.training.bank.account.*;
import pl.training.bank.common.ResultPage;
import pl.training.bank.common.ValidatorService;
import pl.training.bank.disposition.Disposition;
import pl.training.bank.disposition.DispositionService;
import pl.training.bank.operation.Deposit;
import pl.training.bank.operation.Operation;
import pl.training.bank.operation.OperationService;
import pl.training.bank.operation.Withdraw;

import javax.validation.Validation;
import javax.validation.Validator;
import java.util.HashSet;
import java.util.Set;

public class Application {

    public static void main(String[] args) {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        ValidatorService validatorService = new ValidatorService(validator);

        AccountRepository accountRepository = new HashMapAccountRepository();
        AccountNumberGenerator accountNumberGenerator = new IncrementalAccountNumberGenerator();
        AccountService accountService = new AccountService(accountNumberGenerator, accountRepository);

        Set<Operation> operations = new HashSet<>();
        operations.add(new Deposit());
        operations.add(new Withdraw());
        OperationService operationService = new OperationService(operations);

        DispositionService dispositionService = new DispositionService(accountService, operationService, validatorService);

        Account account = accountService.create();

        Disposition deposit = new Disposition(account.getNumber(), 1_000, "deposit");
        Disposition withdraw = new Disposition(account.getNumber(), 500, "withdraw");
        dispositionService.process(deposit);
        dispositionService.process(withdraw);

        ResultPage<Account> resultPage = accountService.get(0, 10);
        resultPage.getData().forEach(System.out::println);
    }

}
