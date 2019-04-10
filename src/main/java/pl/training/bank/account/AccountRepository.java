package pl.training.bank.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.training.bank.common.ResultPage;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long>, AccountRepositoryCustom {

    Optional<Account> getByNumber(String accountNumber);

    @Query("select a from Account a where a.balance >= :balance")
    List<Account> getWithBalance(@Param("balance") Long balance);

}
