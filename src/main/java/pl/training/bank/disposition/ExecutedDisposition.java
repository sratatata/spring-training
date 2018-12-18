package pl.training.bank.disposition;

import lombok.Data;

import javax.persistence.*;

@Table(name = "disposition")
@Entity
@Data
public class ExecutedDisposition {

    @GeneratedValue
    @Id
    private Long id;
    @Column(name = "account_number")
    private String accountNumber;
    private long funds;
    private long timestamp;
    @Column(name = "operation_type")
    private String operationType;

}
