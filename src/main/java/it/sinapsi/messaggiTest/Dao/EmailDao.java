package it.sinapsi.messaggiTest.Dao;

import it.sinapsi.messaggiTest.Dto.EmailDto;
import it.sinapsi.messaggiTest.business.EmailRepository;
import it.sinapsi.messaggiTest.model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EmailDao {
    @Autowired
    private EmailRepository repository;

    public Email create(EmailDto emailDto){
        UUID uuid = UUID.randomUUID();
        Email email = new Email();
        email.setId(uuid);
        email.setMittente(emailDto.getTo());
        email.setBody(emailDto.getBody());
        try{
            return  this.repository.save(email);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
