package pl.training.bank.account;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    AccountTransferObject toAccountTransferObject(Account account);

}
