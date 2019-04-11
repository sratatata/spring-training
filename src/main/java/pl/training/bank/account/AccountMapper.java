package pl.training.bank.account;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import pl.training.bank.common.ResultPage;
import pl.training.bank.common.transferobject.ResultPageTransferObject;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    AccountTransferObject toAccountTransferObject(Account account);

    @IterableMapping(elementTargetType = AccountTransferObject.class)
    List<AccountTransferObject> toAccountTransferObjects(List<Account> accounts);

    ResultPageTransferObject<AccountTransferObject> toResultPageTransferObject(ResultPage<Account> resultPage);

}
