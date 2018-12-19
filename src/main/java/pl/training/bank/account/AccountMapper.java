package pl.training.bank.account;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface AccountMapper {

   AccountTo map(Account account);

   @IterableMapping(elementTargetType = AccountTo.class)
   List<AccountTo> map(List<Account> accounts);

}
