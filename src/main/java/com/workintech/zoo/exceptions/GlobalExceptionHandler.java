package com.workintech.zoo.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ZooException.class)
    public ResponseEntity<ZooErrorResponse> exceptionHandler(ZooException zooException){

        ZooErrorResponse zooErrorResponse=
                new ZooErrorResponse(zooException.getStatus().value(),
                zooException.getMessage(), LocalDateTime.now());

        return new ResponseEntity<>(zooErrorResponse,zooException.getStatus());
    }
}
