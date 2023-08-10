package com.maveric.UserApplication.Exception;

public class InvalidCredentialsException extends RuntimeException{
    public InvalidCredentialsException(String msg)
    {
        super(msg);
    }
}
