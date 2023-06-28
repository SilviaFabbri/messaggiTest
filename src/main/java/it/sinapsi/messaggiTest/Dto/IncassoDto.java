package it.sinapsi.messaggiTest.Dto;

import java.io.Serializable;
import java.math.BigDecimal;


public class IncassoDto implements Serializable {
    private BigDecimal incasso;
    private String meteo = "meteo";
    public BigDecimal getIncasso() {
        return incasso;
    }

    public void setIncasso(BigDecimal incasso) {
        this.incasso = incasso;
    }

    public String getMeteo() {
        return meteo;
    }

    public void setMeteo(String meteo) {
        this.meteo = meteo;
    }

}
