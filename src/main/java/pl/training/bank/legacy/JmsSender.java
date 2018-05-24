package pl.training.bank.legacy;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.Queue;

@RequiredArgsConstructor
public class JmsSender {

    @NonNull
    private JmsTemplate jmsTemplate;
    @NonNull
    private Queue queue;

    public void send(String text) {
        this.jmsTemplate.send(this.queue, session -> session.createTextMessage(text));
    }

}
