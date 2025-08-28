package com.cinearchive.config;

import com.cinearchive.exception.UserOrPasswordInvalidException;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationControllerAdvice {
    @ExceptionHandler(UsernameNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleNotFoundException(UserOrPasswordInvalidException exception){
        return exception.getMessage();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String>  handleNotValidException(MethodArgumentNotValidException exception){
        Map<String, String> map = new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach((error) -> {
            map.put(((FieldError)error).getField(), ((FieldError)error).getDefaultMessage());
        });
        return map;
    }
}
