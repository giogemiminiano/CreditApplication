package com.example.credit.domain.exception;

public class GetCreditApplicationException extends RuntimeException{

    public GetCreditApplicationException(String id){
        super("No se encontro la colicitud con Id: "+id);
    }
}
