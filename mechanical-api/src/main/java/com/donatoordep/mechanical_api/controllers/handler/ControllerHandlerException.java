package com.donatoordep.mechanical_api.controllers.handler;

import com.donatoordep.mechanical_api.exceptions.ONBEmailHasExistsOnDatabaseException;
import com.donatoordep.mechanical_api.exceptions.ONBEntityNotFoundException;
import com.donatoordep.mechanical_api.exceptions.ONBPasswordMinimumCharactersException;
import com.donatoordep.mechanical_api.exceptions.base.ONBExceptionSpecification;
import com.donatoordep.mechanical_api.exceptions.base.StandardError;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerHandlerException {

    @ExceptionHandler(ONBEntityNotFoundException.class)
    public ResponseEntity<StandardError> entityNotFound(ONBEntityNotFoundException exception, HttpServletRequest request) {
        return this.createHandleException(exception, request.getRequestURI());
    }

    @ExceptionHandler(ONBEmailHasExistsOnDatabaseException.class)
    public ResponseEntity<StandardError> emailHasExistsOnDatabase(ONBEmailHasExistsOnDatabaseException exception, HttpServletRequest request) {
        return this.createHandleException(exception, request.getRequestURI());
    }

    @ExceptionHandler(ONBPasswordMinimumCharactersException.class)
    public ResponseEntity<StandardError> passwordMinimumCharacters(ONBPasswordMinimumCharactersException exception, HttpServletRequest request) {
        return this.createHandleException(exception, request.getRequestURI());
    }

    private ResponseEntity<StandardError> createHandleException(ONBExceptionSpecification e, String path) {
        return ResponseEntity.status(HttpStatus.valueOf(e.getStatus())).body(new StandardError(e.getStatus(), e.getError(), path));
    }
}