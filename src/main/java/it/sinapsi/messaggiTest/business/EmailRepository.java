package it.sinapsi.messaggiTest.business;

import it.sinapsi.messaggiTest.model.Email;
import org.springframework.data.keyvalue.repository.KeyValueRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends KeyValueRepository<Email, String> {
}
