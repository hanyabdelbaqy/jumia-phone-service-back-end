package com.jumia.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NoContentException extends Exception{

    private static final long serialVersionUID = 1L;

    public NoContentException(String message){
        super(message);
    }
}