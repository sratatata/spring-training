package pl.training.bank.disposition;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@Data
public class DispositionViewModel {

    @Pattern(regexp = "\\d{26}")
    private String accountNumber;
    @Min(1)
    private long funds;
    private String operationName;

    public void setFunds(long funds) {
        this.funds = funds * 100;
    }

}
