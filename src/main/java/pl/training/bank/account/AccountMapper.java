package pl.training.bank.account;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountMapper {

   AccountTo map(Account account);

   @IterableMapping(elementTargetType = AccountTo.class)
   List<AccountTo> map(List<Account> accounts);

   AccountViewModel toViewModel(Account account);

   @IterableMapping(elementTargetType = AccountViewModel.class)
   List<AccountViewModel> toViewModel(List<Account> accounts);

}
