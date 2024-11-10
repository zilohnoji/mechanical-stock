package com.donatoordep.mechanical_api.exceptions;

import com.donatoordep.mechanical_api.exceptions.base.ONBExceptionSpecification;

public class ONBEntityNotFoundException extends RuntimeException implements ONBExceptionSpecification {

    public final static int STATUS = 404;
    public final static String MESSAGE = "entity not found";

    public ONBEntityNotFoundException() {
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