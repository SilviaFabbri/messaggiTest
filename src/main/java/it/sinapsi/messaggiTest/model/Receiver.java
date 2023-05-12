package it.sinapsi.messaggiTest.model;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    @JmsListener(destination = "casella", containerFactory = "myFactory")
    public void receiveMessage(Email email) {
        System.out.println("Ricevuto <" + email + ">");
    }
}