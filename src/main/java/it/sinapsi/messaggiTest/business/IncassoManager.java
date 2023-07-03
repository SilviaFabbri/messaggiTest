package it.sinapsi.messaggiTest.business;

import it.sinapsi.messaggiTest.Dao.IncassoDao;
import it.sinapsi.messaggiTest.model.Incasso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.POST})
@RequestMapping("/incassi")
public class IncassoManager {
    @Autowired
    private IncassoDao Dao;
    @Autowired
    private IncassoRepository repository;
    @Autowired
    private IncassoScheduler scheduler;

    @GetMapping()
    public BigDecimal aggiornaIncasso(){
        List<Incasso> incassiRedis = repository.findAll();
        BigDecimal incassoSommato = new BigDecimal("0");
        for(Incasso incasso : incassiRedis ){
            incassoSommato = incassoSommato.add(incasso.getIncasso());
        }
        return incassoSommato;
    }
    @GetMapping("/{id}")
    public Optional<Incasso> cercaIncasso(@PathVariable("id") String id){
        Optional<Incasso> incasso =  repository.findById(id);
        if(incasso.isEmpty()){
            throw new RecordNonTrovato();
        }else{
            return incasso;
        }
    }
}
