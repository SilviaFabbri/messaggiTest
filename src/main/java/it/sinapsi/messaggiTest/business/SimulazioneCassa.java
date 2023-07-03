package it.sinapsi.messaggiTest.business;

import it.sinapsi.messaggiTest.Dao.IncassoDao;
import it.sinapsi.messaggiTest.Dto.IncassoDto;
import it.sinapsi.messaggiTest.model.Incasso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.TimerTask;
import java.util.UUID;

@Service
public class SimulazioneCassa extends TimerTask {
    @Autowired
    private IncassoDao Dao;
    @Autowired
    private IncassoScheduler incassoProgrammato;
    UUID uuid =UUID.randomUUID();
    @Scheduled(cron = "0 * 9-14 * * ?")
    public void run(){
            Incasso incasso = new Incasso();
            incasso.setId(uuid);
            incasso.setIncasso(incassoProgrammato.generaIncasso());
            incasso.setMeteo(incasso.getMeteo());
            this.Dao.create(incasso);
        System.out.println("La mia funzione è in esecuzione! " + LocalDateTime.now() + incasso.getIncasso().toString());
    }
}
