package pl.training.bank.disposition;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/dispositions")
@RestController
@RequiredArgsConstructor
public class DispositionRestController {

    @NonNull
    private DispositionService dispositionService;
    @NonNull
    private DispositionMapper dispositionMapper;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> add(@RequestBody DispositionTransferObject dispositionTransferObject) {
        Disposition disposition = dispositionMapper.toDisposition(dispositionTransferObject);
        dispositionService.process(disposition);
        return ResponseEntity.accepted().build();
    }

}
