package com.hotelhub.custom_exceptions;

public class UserAlreadyExistsException extends ApiException {
    public UserAlreadyExistsException(String message) {
        super(message);
    }
}

