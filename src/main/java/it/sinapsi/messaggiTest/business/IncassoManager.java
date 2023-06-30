package it.sinapsi.messaggiTest.business;
import java.util.Calendar;
import it.sinapsi.messaggiTest.Dao.IncassoDao;
import it.sinapsi.messaggiTest.Dto.IncassoDto;
import it.sinapsi.messaggiTest.model.Incasso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
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

    @PostMapping()
    public HttpStatus createIncasso(){
        IncassoDto incasso = new IncassoDto();
        incasso.setIncasso(scheduler.incrementaIncasso());
        incasso.setMeteo(incasso.getMeteo());
        this.Dao.create(incasso);
        scheduler.arrezaIncasso();
        return  HttpStatus.CREATED;
    }
    @GetMapping()
    public BigDecimal aggiornaIncasso(){
        return scheduler.incrementaIncasso();
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
