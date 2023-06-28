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
    private BigDecimal incasso;
    private String meteo;

        public UUID getId() {
            return id;
        }

        public void setId(UUID id) {
            this.id = id;
        }


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

    public Incasso(UUID id, BigDecimal incasso, String meteo) {
        this.id = id;
        this.incasso = incasso;
        this.meteo = meteo;
    }

    @Override
    public String toString() {
        return String.format("id=%s, incasso=%s, meteo=%s", getId(), getIncasso(), getMeteo());
    }
}
