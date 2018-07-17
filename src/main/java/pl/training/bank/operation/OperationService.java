package pl.training.bank.operation;

import lombok.Setter;

import java.util.*;

public class OperationService {

    @Setter
    private Set<Operation> operations = new HashSet<>();

    public void add(Operation operation) {
        operations.add(operation);
    }

    public Operation get(OperationName operationName) {
        return operations.stream()
                .filter(operation -> operation.hasName(operationName.name()))
                .findAny()
                .orElseThrow(UnknownOperationException::new);
    }

}
