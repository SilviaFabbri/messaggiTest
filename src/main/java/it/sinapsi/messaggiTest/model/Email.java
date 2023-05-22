package it.sinapsi.messaggiTest.model;
import jakarta.persistence.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.UUID;

@RedisHash("email")
public class Email implements Serializable {
    @Id
    private UUID id;
    private String mittente;
    private String body;

    public Email() {
    }

    public Email(UUID id, String mittente, String body) {
        this.id = id;
        this.mittente = mittente;
        this.body = body;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getMittente() {
        return mittente;
    }

    public void setMittente(String mittente) {
        this.mittente = mittente;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return String.format("id=%s, mittente=%s, body=%s", getId(), getMittente(), getBody());
    }
}
