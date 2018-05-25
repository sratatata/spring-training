package pl.training.bank.legacy;

import lombok.Setter;
import lombok.extern.java.Log;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

@Log
@Setter
/*@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "BankDS"),
        @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge")
})*/
public class MessageService implements MessageListener {

    @Override
    public void onMessage(Message message) {
        try {
            String text = message.getBody(String.class);
            log.info("Processing new message: " + text);
        } catch (JMSException e) {
            log.warning(e.getMessage());
        }
    }

}