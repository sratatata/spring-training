package pl.training.bank.disposition;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class DispositionTransferObject {

    @Pattern(regexp = "\\d{26}")
    @NotNull
    private String accountNumber;
    @Min(1)
    private long funds;
    private String operationName;

}
