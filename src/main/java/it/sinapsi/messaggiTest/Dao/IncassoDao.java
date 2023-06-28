package it.sinapsi.messaggiTest.Dao;

import it.sinapsi.messaggiTest.Dto.IncassoDto;
import it.sinapsi.messaggiTest.business.IncassoRepository;
import it.sinapsi.messaggiTest.model.Incasso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class IncassoDao {
    @Autowired
    private IncassoRepository repository;

    public Incasso create(IncassoDto dto){
        UUID uuid = UUID.randomUUID();
        Incasso incasso = new Incasso();
        incasso.setId(uuid);
        incasso.setIncasso(dto.getIncasso());
        incasso.setMeteo(dto.getMeteo());
        try{
            return  this.repository.save(incasso);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
