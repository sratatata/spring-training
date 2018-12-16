package pl.training.bank.disposition;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import pl.training.bank.account.Account;
import pl.training.bank.account.AccountService;
import pl.training.bank.operation.Operation;
import pl.training.bank.operation.OperationService;

import static java.util.Arrays.stream;

@RequiredArgsConstructor
public class DispositionService {

    @NonNull
    private AccountService accountService;
    @NonNull
    private OperationService operationService;

    public void process(Disposition disposition) {
        Account account = accountService.getBy(disposition.getAccountNumber());
        Operation operation = operationService.getBy(disposition.getOperationName());
        operation.execute(account, disposition.getFunds());
        accountService.update(account);
    }

    public void process(Disposition... dispositions) {
        stream(dispositions).forEach(this::process);
    }

}
