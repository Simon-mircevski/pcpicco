package com.example.pcpicco.model.exceptions;

public class InvalidUserException extends RuntimeException{
    public InvalidUserException(){
        super("Invalid user credentials, check if e-mail or password was entered correctly");
    }
}
