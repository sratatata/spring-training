package pl.training.bank.disposition;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.training.bank.operation.OperationName;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Disposition {

    @Pattern(regexp = "\\d{26}")
    @NotNull
    private String accountNumber;
    @Min(1)
    private long funds;
    private OperationName operationName;

}
