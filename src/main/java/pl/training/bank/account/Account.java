package pl.training.bank.account;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(name = Account.SELECT_ACCOUNT_BY_NUMBER, query = "select a from Account a where a.number = :number"),
        @NamedQuery(name = Account.SELECT_ACCOUNTS, query = "select a from Account a"),
        @NamedQuery(name = Account.SELECT_LAST_ACCOUNT_NUMBER, query = "select max(a.number) from Account a")
})
@Table(indexes = @Index(name = "account_number_index", columnList = "account_number"))
@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@Data
public class Account {

    public static final String SELECT_ACCOUNT_BY_NUMBER = "selectAccountByNumber";
    public static final String SELECT_ACCOUNTS = "selectAccounts";
    public static final String SELECT_LAST_ACCOUNT_NUMBER = "selectLastAccountNumber";

    @GeneratedValue
    @Id
    private Long id;
    @Column(name = "account_number", unique = true)
    @NonNull
    private String number;
    private long balance;

    public void deposit(long funds) {
        balance += funds;
    }

    public void withdraw(long funds) {
        balance -= funds;
    }

}
