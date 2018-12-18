package pl.training.bank.disposition;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

@Getter
@Setter
public class LargeDepositEvent extends ApplicationEvent {

    private Disposition disposition;

    public LargeDepositEvent(Object source) {
        super(source);
    }

}
