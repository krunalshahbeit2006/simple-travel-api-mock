package com.afkl.exercises.spring.common;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpServerErrorException;

import lombok.extern.slf4j.Slf4j;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.SERVICE_UNAVAILABLE;

@Slf4j
@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(Throwable.class)
    public HttpEntity handleGlobalException(Throwable t) {
        log.error("Unable to process request.", t);
        return new ResponseEntity(SERVICE_UNAVAILABLE);
    }

    @ExceptionHandler(HttpServerErrorException.class)
    public HttpEntity handleGlobalException(HttpServerErrorException e) {
        return new ResponseEntity(e.getStatusCode());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public HttpEntity handleBadRequest() {
        return new ResponseEntity(BAD_REQUEST);
    }

}
