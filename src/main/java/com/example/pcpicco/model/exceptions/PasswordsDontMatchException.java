package com.example.pcpicco.model.exceptions;

public class PasswordsDontMatchException extends RuntimeException{
    public PasswordsDontMatchException(){
        super("Passwords do not match!");
    }
}
