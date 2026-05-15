package com.example.credit.domain.exception;

public class InvalidStatusTransitionException extends RuntimeException{

    public InvalidStatusTransitionException(String currentStatus,String requestStatus){
        super("El cambio de estado: "+currentStatus+" -> "+requestStatus+". No es permitido.");
    }
}
