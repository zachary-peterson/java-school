package com.lambdaschool.schools.exceptions;

public class LambdaNFException extends RuntimeException
{
    public LambdaNFException(String message)
    {
        super("Found an issue with School: " + message);
    }
}
