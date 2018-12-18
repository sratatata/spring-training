package pl.training.bank.disposition;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Aspect
@RequiredArgsConstructor
public class ExecutedDispositionLogger {

    @NonNull
    private ExecutedDispositionRepository executedDispositionRepository;

    @AfterReturning("execution(void pl.training.bank.disposition.DispositionService.process(..)) && args(disposition)")
    public void onOperationSuccess(Disposition disposition) {
        ExecutedDisposition executedDisposition = map(disposition);
        executedDispositionRepository.save(executedDisposition);
    }

    private ExecutedDisposition map(Disposition disposition) {
        ExecutedDisposition executedDisposition = new ExecutedDisposition();
        executedDisposition.setAccountNumber(disposition.getAccountNumber());
        executedDisposition.setFunds(disposition.getFunds());
        executedDisposition.setOperationType(disposition.getOperationName());
        executedDisposition.setTimestamp(System.currentTimeMillis());
        return executedDisposition;
    }

}
