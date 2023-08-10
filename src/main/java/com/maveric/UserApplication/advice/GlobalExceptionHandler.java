package com.maveric.UserApplication.advice;

import com.maveric.UserApplication.Exception.InvalidCredentialsException;
import com.maveric.UserApplication.Exception.UnadequateDetailsException;
import com.maveric.UserApplication.Exception.UserNotFoundExpception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)

    @ExceptionHandler(MethodArgumentNotValidException.class)

    public Map<String, String> handleInvalidArgument(MethodArgumentNotValidException ex) {

        Map<String, String> err = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error -> {



            err.put(error.getField(), error.getDefaultMessage());



        });

        return err;

    }
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(UserNotFoundExpception.class)
    public Map<String,String > userNotFoundException(UserNotFoundExpception ex)
    {
        Map<String,String > error=new HashMap<>();
        error.put("Message",ex.getMessage());
        return error;
    }

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(InvalidCredentialsException.class)
    public Map<String,String > invalidCredentailsException(InvalidCredentialsException ex)
    {
        Map<String,String > error=new HashMap<>();
        error.put("Message",ex.getMessage());
        return error;
    }

//    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
//    @ExceptionHandler(UnadequateDetailsException.class)
//    public Map<String,String > UnadequateDetailsException(UnadequateDetailsException ex)
//    {
//        Map<String,String > error=new HashMap<>();
//        error.put("Message",ex.getMessage());
//        return error;
//    }

}
