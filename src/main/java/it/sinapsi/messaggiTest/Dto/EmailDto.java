package it.sinapsi.messaggiTest.Dto;

import java.io.Serializable;

public class EmailDto implements Serializable {
    private String to;
    private String body;

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
