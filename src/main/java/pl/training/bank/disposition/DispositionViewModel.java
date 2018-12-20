package pl.training.bank.disposition;

import lombok.Data;
import pl.training.bank.common.validator.Funds;

import javax.validation.constraints.Pattern;

@Data
public class DispositionViewModel {

    @Pattern(regexp = "\\d{26}")
    private String accountNumber;
    @Funds
    private long funds;
    private String operationName;

}
