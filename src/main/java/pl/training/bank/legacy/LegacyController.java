package pl.training.bank.legacy;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.jndi.JndiTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.NamingException;

@RequiredArgsConstructor
@RestController
public class LegacyController {

    @NonNull
    private JmsSender queueSender;
    private JndiTemplate jndiTemplate = new JndiTemplate();

    @RequestMapping(value = "time", method = RequestMethod.GET)
    public Long getTime() throws NamingException {
        TimeService timeService = jndiTemplate.lookup("java:global/bank-1.0-SNAPSHOT/TimeService", TimeService.class);
        return timeService.getTime();
    }

    @RequestMapping(value = "messages", method = RequestMethod.POST)
    public ResponseEntity sendMessage() {
        queueSender.send("JMS message");
        return ResponseEntity.ok().build();
    }

}
