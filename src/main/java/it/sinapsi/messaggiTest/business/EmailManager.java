package it.sinapsi.messaggiTest.business;

import it.sinapsi.messaggiTest.Dao.EmailDao;
import it.sinapsi.messaggiTest.Dto.EmailDto;
import it.sinapsi.messaggiTest.model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
public class EmailManager {
    @Autowired
    private EmailDao emailDao;
    @Autowired
    private EmailRepository emailRepository;

    @PostMapping()
    public HttpStatus createEmail(@RequestBody EmailDto emailDto){
        this.emailDao.create(emailDto);
        return  HttpStatus.CREATED;
    }
    @GetMapping()
    public Iterable<Email> findAll(){ return emailRepository.findAll();}
}