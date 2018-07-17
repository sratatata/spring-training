package pl.training.bank.disposition;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import pl.training.bank.account.Account;
import pl.training.bank.account.AccountService;
import pl.training.bank.common.ValidatorService;
import pl.training.bank.operation.Operation;
import pl.training.bank.operation.OperationService;

import static java.util.Arrays.stream;

@RequiredArgsConstructor
public class DispositionService {

    @NonNull
    private AccountService accountService;
    @NonNull
    private OperationService operationService;
    @NonNull
    private ValidatorService validatorService;

    public void process(Disposition disposition) {
        validatorService.validate(disposition, InvalidDispositionException.class);
        Account account = accountService.get(disposition.getAccountNumber());
        Operation operation = operationService.get(disposition.getOperationName());
        operation.execute(account, disposition.getFunds());
        accountService.update(account);
    }

    public void process(Disposition... dispositions) {
        stream(dispositions).forEach(this::process);
    }

}
