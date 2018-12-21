package pl.training.bank.user;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Table(name = "client")
@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@Data
public class User {

    @GeneratedValue
    @Id
    private Long id;
    @Column(unique = true)
    @NonNull
    private String login;
    @NonNull
    private String password;
    @NonNull
    private String role;
    private boolean enabled;

}
