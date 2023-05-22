package it.sinapsi.messaggiTest.business;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class ControllerRecordException {
    //Risposta via http dell'errore in questione, il record cercato tramite id non si trova più in redis
    @ExceptionHandler(value = RecordNonTrovato.class)
    public ResponseEntity<Object> exception(RecordNonTrovato exception){
        return new ResponseEntity<>("Il Record non è più presente nel database Redis", HttpStatus.NOT_FOUND);
    }
}