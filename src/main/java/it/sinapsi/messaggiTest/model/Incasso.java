package it.sinapsi.messaggiTest.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import jakarta.persistence.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@RedisHash("incassi")
public class Incasso implements Serializable {
    @Id
    private UUID id;
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, timezone = JsonFormat.DEFAULT_TIMEZONE)
    private LocalDate giorno;

    private BigDecimal totale;
    private BigDecimal gastronomia;
    private BigDecimal fresco;
    private BigDecimal secco;
    private BigDecimal ortofrutta;
    private BigDecimal surgelati;
    private String meteo;

        public UUID getId() {
            return id;
        }

        public void setId(UUID id) {
            this.id = id;
        }

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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Incasso incasso = (Incasso) o;
            return Objects.equals(id, incasso.id);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }

    public Incasso() {
    }

    public Incasso(UUID id, LocalDate giorno, BigDecimal totale, BigDecimal gastronomia, BigDecimal fresco, BigDecimal secco, BigDecimal ortofrutta, BigDecimal surgelati, String meteo) {
        this.id = id;
        this.giorno = giorno;
        this.totale = totale;
        this.gastronomia = gastronomia;
        this.fresco = fresco;
        this.secco = secco;
        this.ortofrutta = ortofrutta;
        this.surgelati = surgelati;
        this.meteo = meteo;
    }

    @Override
    public String toString() {
        return String.format("id=%s, giorno=%s, totale=%s, gastronomia=%s, fresco=%s, secco=%s, ortofrutta=%s, surgelati=%s, meteo=%s", getId(),
                getGiorno(), getTotale(),getGastronomia(),getFresco(),getSecco(),getOrtofrutta(),getSurgelati(), getMeteo());
    }
}
