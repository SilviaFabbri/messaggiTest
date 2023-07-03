package it.sinapsi.messaggiTest.business;

import net.datafaker.Faker;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
@Service
public class IncassoScheduler {
//è schedulata da IncassoManager
    Faker faker = new Faker();
    BigDecimal incasso = new BigDecimal("0");

    public BigDecimal generaIncasso(){
        return incasso =  BigDecimal.valueOf(faker.number().randomDouble(2, 1, 50));
    }
    public void azzeraIncasso(){
        incasso = new BigDecimal("0");
    }
}
