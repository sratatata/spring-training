package pl.training.bank.account.controller;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.training.bank.account.dto.AccountDto;
import pl.training.bank.account.entity.Account;
import pl.training.bank.account.services.AccountService;
import pl.training.bank.common.UriBuilder;
import pl.training.bank.common.mapper.Mapper;

import java.net.URI;

@RequiredArgsConstructor
@RequestMapping("/api/v1/accounts")
@RestController
public class AccountController {

    @NonNull
    private Mapper mapper;
    @NonNull
    private AccountService accountService;
    private UriBuilder uriBuilder = new UriBuilder();

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createAccount() {
        Account account = accountService.createAccount();
        URI uri = uriBuilder.requestUriWithId(account.getId());
        return ResponseEntity.created(uri).body(mapper.map(account, AccountDto.class));
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public AccountDto getById(@PathVariable("id") Long id) {
        Account account = accountService.getAccountById(id);
        return mapper.map(account, AccountDto.class);
    }

}
