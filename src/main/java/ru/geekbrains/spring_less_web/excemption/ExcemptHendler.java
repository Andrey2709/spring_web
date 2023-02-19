package ru.geekbrains.spring_less_web.excemption;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

@ControllerAdvice
public class ExcemptHendler {




    @ExceptionHandler
    public ResponseEntity<ExceptDescript> exemptionNotFound(ResorseNotFoundExecemption e) {
            return  new ResponseEntity<>(new ExceptDescript(e.getMessage(), HttpStatus.NOT_FOUND.value()),HttpStatus.NOT_FOUND);
    }
}
