package com.github.adamflorczak.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler({ValidationException.class})
    @ResponseBody
    public ResponseEntity<ValidationError[]> handleValidationException(ValidationException e){
        return new ResponseEntity<>((ValidationError[]) e.getErrorList().toArray(), HttpStatus.FORBIDDEN);
    }
}
