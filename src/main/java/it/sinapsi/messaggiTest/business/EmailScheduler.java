package it.sinapsi.messaggiTest.business;


import it.sinapsi.messaggiTest.model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@EnableJms
@EnableScheduling
public class EmailScheduler {
    @Autowired
    private EmailRepository repository;
    @Autowired
    private JmsTemplate jmsTemplate;


    public Iterable<Email> findAll(){ return repository.findAll();}


    @Scheduled(fixedDelay = 60000)
    public void scheduleEmail(){
        for(Email email: findAll()){
            jmsTemplate.convertAndSend("email",  email);
        }
    }
}
