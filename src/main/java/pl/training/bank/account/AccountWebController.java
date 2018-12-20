package pl.training.bank.account;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.training.bank.common.PageViewModel;
import pl.training.bank.common.ResultPage;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AccountWebController {

    @NonNull
    private AccountService accountService;
    @NonNull
    private AccountMapper accountMapper;

    @RequestMapping(value = "create-account.html", method = RequestMethod.GET)
    public ModelAndView createAccount() {
        Account account = accountService.create();
        AccountViewModel accountViewModel = accountMapper.toViewModel(account);
        ModelAndView modelAndView = new ModelAndView("account-created");
        modelAndView.addObject(accountViewModel);
        return modelAndView;
    }

    @RequestMapping(value = "show-accounts.html", method = RequestMethod.GET)
    public ModelAndView showAccounts(@RequestParam(value = "pageNumber", defaultValue = "0") int pageNumber,
                                     @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        ResultPage<Account> accountsPage = accountService.get(pageNumber, pageSize);
        List<AccountViewModel> accountViewModels = accountMapper.toViewModel(accountsPage.getData());
        PageViewModel pageViewModel = new PageViewModel<>(accountViewModels, accountsPage.getPageNumber(), accountsPage.getTotalPages());
        ModelAndView modelAndView = new ModelAndView("accounts");
        modelAndView.addObject(pageViewModel);
        return modelAndView;
    }

}
