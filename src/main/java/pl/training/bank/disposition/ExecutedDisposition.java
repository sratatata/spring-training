package pl.training.bank.disposition;

import lombok.Data;

@Data
public class ExecutedDisposition {

    private Long id;
    private String accountNumber;
    private long funds;
    private long timestamp;
    private String operationType;

}
