package pl.training.bank.legacy;

import org.springframework.jms.annotation.JmsListener;

public class JmsReceiver {

    @JmsListener(destination = "BankDS")
    public void onMessage(String text) {
        System.out.println("New message: " + text);
    }

}