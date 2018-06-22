package com.github.adamflorczak.exceptions;

import java.util.List;

public class ValidationException extends RuntimeException {

    List<ValidationError> errorList;


    public ValidationException(){

    }

    public ValidationException(List<ValidationError> errorList) {
        this.errorList = errorList;
    }

    public List<ValidationError> getErrorList() {
        return errorList;
    }
}
