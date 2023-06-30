package it.sinapsi.messaggiTest.business;

import net.datafaker.Faker;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
@Service
public class IncassoScheduler {
//è schedulata da frontend
    Faker faker = new Faker();
    BigDecimal incasso = new BigDecimal("0");

    public BigDecimal incrementaIncasso(){
        BigDecimal numeriRandom =  BigDecimal.valueOf(faker.number().randomDouble(2, 1, 20));
        incasso = incasso.add(numeriRandom);
        return incasso;
    }
    public void arrezaIncasso(){
        incasso = new BigDecimal("0");
    }
}
