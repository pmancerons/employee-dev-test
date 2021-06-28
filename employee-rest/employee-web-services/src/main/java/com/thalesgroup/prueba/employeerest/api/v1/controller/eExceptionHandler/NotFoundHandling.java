package com.thalesgroup.prueba.employeerest.api.v1.controller.eExceptionHandler;

import com.thalesgroup.prueba.employeerest.api.v1.exceptions.NotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class NotFoundHandling extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object> handlerNotFounException(Exception e, WebRequest webRequest){
        return new ResponseEntity<>("Resource Not Found" , new HttpHeaders(), HttpStatus.NOT_FOUND);
    }
}
