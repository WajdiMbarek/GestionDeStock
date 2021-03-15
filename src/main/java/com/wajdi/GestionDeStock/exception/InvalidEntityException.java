package com.wajdi.GestionDeStock.exception;

import lombok.Getter;

import java.util.List;

public class InvalidEntityException extends RuntimeException{

    @Getter
    private ErrorCodes errorCode;
    @Getter
    private List<String> errors;

    public InvalidEntityException(String message){
        super(message);
    }

    private InvalidEntityException(String message, Throwable cause){
        super(message,cause);
    }
    private InvalidEntityException(String message, Throwable cause,ErrorCodes errorCode){
        super(message,cause);
        this.errorCode = errorCode;
    }
    public InvalidEntityException(String message,ErrorCodes errorCode){
        super(message);
        this.errorCode = errorCode;
    }
    public InvalidEntityException(String message,ErrorCodes errorCode,List<String> errors){
        super(message);
        this.errorCode = errorCode;
        this.errors = errors;
    }


}

