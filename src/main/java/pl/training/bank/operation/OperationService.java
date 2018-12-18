package pl.training.bank.operation;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class OperationService {

    @NonNull
    private Set<Operation> operations;

    public Operation getBy(String operationName) {
        return operations.stream()
                .filter(operation -> operation.hasName(operationName))
                .findAny()
                .orElseThrow(UnknownOperationException::new);
    }

}
