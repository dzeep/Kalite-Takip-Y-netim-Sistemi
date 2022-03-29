package com.mergen.vtys.vtysdatabaseap.Advice;

import liquibase.pro.packaged.E;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ApıExpectionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(IllegalArgumentException.class)
    public final ResponseEntity<ExpectionResponse>  illegalException (Exception exception, WebRequest request){
      ExpectionResponse expectionResponse = new ExpectionResponse(LocalDateTime.now(),exception.getMessage(),"1000");
              return new ResponseEntity<ExpectionResponse>(expectionResponse, HttpStatus.EXPECTATION_FAILED);
}

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExpectionResponse>  expection (Exception exception, WebRequest request){
        ExpectionResponse expectionResponse = new ExpectionResponse(LocalDateTime.now(),exception.getMessage(),"5000");
        return new ResponseEntity<ExpectionResponse>(expectionResponse, HttpStatus.EXPECTATION_FAILED);
    }



}

    