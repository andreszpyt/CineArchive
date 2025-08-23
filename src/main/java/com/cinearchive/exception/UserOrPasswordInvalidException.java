package com.cinearchive.exception;

public class UserOrPasswordInvalidException extends RuntimeException {
    public UserOrPasswordInvalidException(String message) {
        super(message);
    }
}
