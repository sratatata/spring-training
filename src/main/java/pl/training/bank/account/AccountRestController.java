package pl.training.bank.account;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.training.bank.common.UriBuilder;

import java.net.URI;

@RequestMapping("/api/v1/accounts")
@RestController
@RequiredArgsConstructor
public class AccountRestController {

    @NonNull
    private AccountService accountService;
    @NonNull
    private AccountMapper accountMapper;
    private UriBuilder uriBuilder = new UriBuilder();

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<AccountTransferObject> create() {
        Account account = accountService.create();
        URI resourceUri = uriBuilder.requestUriWithId(account.getId());
        AccountTransferObject accountTransferObject = accountMapper.toAccountTransferObject(account);
        return ResponseEntity.created(resourceUri).body(accountTransferObject);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public AccountTransferObject getById(@PathVariable("id")  Long id) {
        Account account = accountService.getById(id);
        return accountMapper.toAccountTransferObject(account);
    }

    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity onAccountNotFoundException(AccountNotFoundException ex) {
        return ResponseEntity.notFound().build();
    }

}
