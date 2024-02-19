package com.example.springBootAssessment.exceptions;

public class EntityAlreadyExistException extends RuntimeException{
    public EntityAlreadyExistException(String message)
    {
        super(message);
    }
}
