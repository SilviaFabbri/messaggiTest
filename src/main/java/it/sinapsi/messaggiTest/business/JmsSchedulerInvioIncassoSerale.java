package it.sinapsi.messaggiTest.business;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.jms.JMSException;
import jakarta.jms.TextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@EnableJms
public class JmsSchedulerInvioIncassoSerale {

    @Autowired
    private IncassoRepository repository;


    @JmsListener(destination = "ricevuto", containerFactory = "myFactory")
    public void receiveMessage(TextMessage textMessage) throws JsonProcessingException, JMSException {
        System.err.println(textMessage.getText());
            repository.deleteAll();
        System.err.println("risposta arrivata");
    }
}