package com.dws.application.exception;

import org.springframework.http.HttpStatus;

public class ResourcesException extends RuntimeException {

    public ResourcesException(HttpStatus status, String message, Object description) {
        super(String.format("HTTP error %s, %s, '%s'", status, message, description));
    }
}
