package com.donatoordep.mechanical_api.exceptions;

import com.donatoordep.mechanical_api.exceptions.base.ONBExceptionSpecification;

public class ONBEmailHasExistsOnDatabaseException extends RuntimeException implements ONBExceptionSpecification {

    private final static int STATUS = 422;
    private final static String MESSAGE = "email has exists";

    public ONBEmailHasExistsOnDatabaseException() {
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