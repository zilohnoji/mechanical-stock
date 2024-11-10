package com.donatoordep.mechanical_api.exceptions;

import com.donatoordep.mechanical_api.exceptions.base.ONBExceptionSpecification;

public class ONBPasswordMinimumCharactersException extends RuntimeException implements ONBExceptionSpecification {

    public final static int STATUS = 400;
    public final static String MESSAGE = "minimum characters is 8";

    public ONBPasswordMinimumCharactersException() {
        super(MESSAGE);
    }

    @Override
    public Integer getStatus() {
        return STATUS;
    }

    @Override
    public String getError() {
        return MESSAGE;
    }
}