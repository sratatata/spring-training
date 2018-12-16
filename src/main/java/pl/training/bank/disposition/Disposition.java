package pl.training.bank.disposition;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Disposition {

    private String accountNumber;
    private long funds;
    private String operationName;

}
