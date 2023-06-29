package it.sinapsi.messaggiTest.business;

import it.sinapsi.messaggiTest.Dao.IncassoDao;
import it.sinapsi.messaggiTest.Dto.IncassoDto;
import it.sinapsi.messaggiTest.model.Incasso;
import net.datafaker.Faker;
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
    Faker faker = new Faker();
    BigDecimal incasso = BigDecimal.valueOf(faker.number().randomDouble(2, 4, 60));

    @PostMapping()
    public HttpStatus createIncasso(@RequestBody IncassoDto dto){
        this.Dao.create(dto);
        return  HttpStatus.CREATED;
    }
    @GetMapping()
    public BigDecimal aggiornaIncasso(){

        return incasso;
    }
    //public Iterable<Incasso> cercaTutto(){
       // return repository.findAll();
    //}
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
