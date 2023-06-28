package it.sinapsi.messaggiTest.business;


import it.sinapsi.messaggiTest.model.Incasso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@EnableJms
@EnableScheduling
public class JmsScheduler {
    @Autowired
    private IncassoRepository repository;
    @Autowired
    private JmsTemplate jmsTemplate;

    public Iterable<Incasso> cercaTutto(){ return repository.findAll();}

    @Scheduled(fixedDelay = 60000)
    public void scheduleIncasso(){
        for(Incasso incasso : cercaTutto()){
            jmsTemplate.convertAndSend("incassi", incasso);
            repository.deleteAll();
            System.out.println(incasso);
        }
    }
}
