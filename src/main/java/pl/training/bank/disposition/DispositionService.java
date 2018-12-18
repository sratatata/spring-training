package pl.training.bank.disposition;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import pl.training.bank.account.Account;
import pl.training.bank.account.AccountService;
import pl.training.bank.common.ValidatorService;
import pl.training.bank.operation.Operation;
import pl.training.bank.operation.OperationService;

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
        Account account = accountService.getBy(disposition.getAccountNumber());
        Operation operation = operationService.getBy(disposition.getOperationName());
        operation.execute(account, disposition.getFunds());
        accountService.update(account);
    }

}
