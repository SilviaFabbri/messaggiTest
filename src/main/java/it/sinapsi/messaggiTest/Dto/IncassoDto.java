package it.sinapsi.messaggiTest.Dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

public class IncassoDto implements Serializable {
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate giorno;
    private BigDecimal totale;
    private BigDecimal gastronomia;
    private BigDecimal fresco;
    private BigDecimal secco;
    private BigDecimal ortofrutta;
    private BigDecimal surgelati;
    private String meteo;
    public LocalDate getGiorno() {
        return giorno;
    }

    public void setGiorno(LocalDate giorno) {
        this.giorno = giorno;
    }

    public BigDecimal getTotale() {
        return totale;
    }

    public void setTotale(BigDecimal totale) {
        this.totale = totale;
    }

    public BigDecimal getGastronomia() {
        return gastronomia;
    }

    public void setGastronomia(BigDecimal gastronomia) {
        this.gastronomia = gastronomia;
    }

    public BigDecimal getFresco() {
        return fresco;
    }

    public void setFresco(BigDecimal fresco) {
        this.fresco = fresco;
    }

    public BigDecimal getSecco() {
        return secco;
    }

    public void setSecco(BigDecimal secco) {
        this.secco = secco;
    }

    public BigDecimal getOrtofrutta() {
        return ortofrutta;
    }

    public void setOrtofrutta(BigDecimal ortofrutta) {
        this.ortofrutta = ortofrutta;
    }

    public BigDecimal getSurgelati() {
        return surgelati;
    }

    public void setSurgelati(BigDecimal surgelati) {
        this.surgelati = surgelati;
    }

    public String getMeteo() {
        return meteo;
    }

    public void setMeteo(String meteo) {
        this.meteo = meteo;
    }

}
