package com.lambdaschool.schools.exceptions;

public class LambdaException extends RuntimeException
{
    public LambdaException(String message)
    {
        super("Found an issue with School: " + message);
    }
}
