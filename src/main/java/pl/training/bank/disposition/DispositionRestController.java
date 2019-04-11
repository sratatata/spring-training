package pl.training.bank.disposition;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping(value = "/api/v1/dispositions", consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
@RestController
@RequiredArgsConstructor
public class DispositionRestController {

    @NonNull
    private DispositionService dispositionService;
    @NonNull
    private DispositionMapper dispositionMapper;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> add(@Valid @RequestBody DispositionTransferObject dispositionTransferObject, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }
        Disposition disposition = dispositionMapper.toDisposition(dispositionTransferObject);
        dispositionService.process(disposition);
        return ResponseEntity.accepted().build();
    }

}
