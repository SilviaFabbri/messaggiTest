package it.sinapsi.messaggiTest.business;

import it.sinapsi.messaggiTest.Dao.IncassoDao;
import it.sinapsi.messaggiTest.Dto.IncassoDto;
import it.sinapsi.messaggiTest.model.Incasso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/incassi")
public class IncassoManager {
    @Autowired
    private IncassoDao Dao;
    @Autowired
    private IncassoRepository repository;

    @PostMapping()
    public HttpStatus createIncasso(@RequestBody IncassoDto dto){
        this.Dao.create(dto);
        return  HttpStatus.CREATED;
    }
    @GetMapping()
    public Iterable<Incasso> cercaTutto(){
        return repository.findAll();
    }
    @GetMapping("/{id}")
    public Optional<Incasso> cercaEmail(@PathVariable("id") String id){
        Optional<Incasso> incasso =  repository.findById(id);
        if(incasso.isEmpty()){
            throw new RecordNonTrovato();
        }else{
            return incasso;
        }

    }
}
