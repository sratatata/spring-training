package pl.training.bank.operation;

import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

public class OperationService {

    @Setter
    private Set<Operation> definedOperations = new HashSet<>();

     public Operation getBy(String operationName) {
        return definedOperations.stream()
                .filter(operation -> operation.hasName(operationName))
                .findAny()
                .orElseThrow(UnknownOperationException::new);
    }

}
