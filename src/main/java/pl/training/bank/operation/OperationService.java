package pl.training.bank.operation;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@RequiredArgsConstructor
public class OperationService {

    @NonNull
    private Set<Operation> definedOperations;

    public Operation getBy(String operationName) {
        return definedOperations.stream()
                .filter(operation -> operation.hasName(operationName))
                .findAny()
                .orElseThrow(UnknownOperationException::new);
    }

}
