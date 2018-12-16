package pl.training.bank.operation;

import lombok.Setter;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class OperationService {

    @Setter
    private Set<Operation> definedOperations = new HashSet<>();

    public void add(Operation... operations) {
        Collections.addAll(definedOperations, operations);
    }

    public Operation getBy(String operationName) {
        return definedOperations.stream()
                .filter(operation -> operation.hasName(operationName))
                .findAny()
                .orElseThrow(UnknownOperationException::new);
    }

}
