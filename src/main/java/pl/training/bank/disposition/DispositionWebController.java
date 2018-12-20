package pl.training.bank.disposition;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@RequestMapping("disposition.html")
@Controller
@RequiredArgsConstructor
public class DispositionWebController {

    @NonNull
    private DispositionService dispositionService;
    @NonNull
    private DispositionMapper dispositionMapper;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showDispositionForm() {
        ModelAndView modelAndView = new ModelAndView("disposition-form");
        modelAndView.addObject(new DispositionViewModel());
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processDisposition(@Valid DispositionViewModel dispositionViewModel, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "disposition-form";
        }
        Disposition disposition = dispositionMapper.map(dispositionViewModel);
        dispositionService.process(disposition);
        return "redirect:index.html";
    }

}
