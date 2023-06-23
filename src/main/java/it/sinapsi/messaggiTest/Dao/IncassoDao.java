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
        incasso.setTotale(dto.getTotale());
        incasso.setGiorno(dto.getGiorno());
        incasso.setGastronomia(dto.getGastronomia());
        incasso.setFresco(dto.getFresco());
        incasso.setSecco(dto.getSecco());
        incasso.setOrtofrutta(dto.getOrtofrutta());
        incasso.setSurgelati(dto.getSurgelati());
        incasso.setMeteo(dto.getMeteo());
        try{
            return  this.repository.save(incasso);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
