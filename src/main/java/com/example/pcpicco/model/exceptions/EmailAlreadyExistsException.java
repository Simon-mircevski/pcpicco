package com.example.pcpicco.model.exceptions;

public class EmailAlreadyExistsException extends RuntimeException{
    public EmailAlreadyExistsException(){
        super("Email is already in use");
    }
}
