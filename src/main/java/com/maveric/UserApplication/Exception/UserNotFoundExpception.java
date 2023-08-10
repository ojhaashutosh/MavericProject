package com.maveric.UserApplication.Exception;

public class UserNotFoundExpception extends RuntimeException {

    public UserNotFoundExpception(String msg)
    {
        super(msg);
    }
}
