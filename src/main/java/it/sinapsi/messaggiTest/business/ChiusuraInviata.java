package it.sinapsi.messaggiTest.business;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.sinapsi.messaggiTest.Dao.IncassoDao;
import it.sinapsi.messaggiTest.Dto.IncassoDto;
import it.sinapsi.messaggiTest.model.Incasso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.TimerTask;
import java.util.UUID;

@Service
public class ChiusuraInviata extends TimerTask {

    @Autowired
    private IncassoRepository repository;
    @Autowired
    private JmsTemplate jmsTemplate;
    @Autowired
    private IncassoScheduler azzeramento;
    @Autowired
    private IncassoDao dao;

    @Scheduled(cron = "0 0 12 * * *")
    public void run(){
        System.err.println("è entrato");
        if(this.repository != null){
            List<Incasso> incassiRedis = this.repository.findAll();
                BigDecimal incassoSommato = new BigDecimal("0");
                for (Incasso incasso : incassiRedis) {
                    incassoSommato = incassoSommato.add(incasso.getIncasso());

                }
                Incasso incassoChiusura = new Incasso();
                UUID uuid = UUID.randomUUID();
                incassoChiusura.setId(uuid);
                incassoChiusura.setIncasso(incassoSommato);
                incassoChiusura.setMeteo("meteo");
                azzeramento.azzeraIncasso();
                dao.create(incassoChiusura);
                jmsTemplate.convertAndSend("incassi", incassoChiusura);
            System.out.println("L'incasso è stato inviato'");
        }else{
            System.err.println("La repositori fa i capricci!");
        }

    }
}