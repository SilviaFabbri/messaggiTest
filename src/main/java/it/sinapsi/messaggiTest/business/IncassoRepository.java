package it.sinapsi.messaggiTest.business;

import it.sinapsi.messaggiTest.model.Incasso;
import org.springframework.data.keyvalue.repository.KeyValueRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncassoRepository extends KeyValueRepository<Incasso, String> {
}
