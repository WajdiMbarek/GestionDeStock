package com.wajdi.GestionDeStock.exception;

import lombok.Getter;

public class EntityNotFoundException extends RuntimeException {
    @Getter
    private ErrorCodes errorCode;

    public EntityNotFoundException(String message){
        super(message);
    }

    private EntityNotFoundException(String message, Throwable cause){
        super(message,cause);
    }
    private EntityNotFoundException(String message, Throwable cause,ErrorCodes errorCode){
        super(message,cause);
        this.errorCode = errorCode;
    }
    public EntityNotFoundException(String message,ErrorCodes errorCode){
        super(message);
        this.errorCode = errorCode;
    }

}
