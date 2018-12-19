package pl.training.bank.disposition;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "disposition")
@Data
public class DispositionTo {

    @Pattern(regexp = "\\d{26}")
    private String accountNumber;
    @Min(1)
    private long funds;
    private String operationName;

}
