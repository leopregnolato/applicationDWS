package com.dws.application.config;

import com.dws.application.exception.ResourcesException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourcesException.class)
    public ResponseEntity<ResourcesException> handleResourceNotFoundException(
            ResourcesException ex,
            WebRequest request) {

        HttpStatus status = HttpStatus.NOT_FOUND;

        ResourcesException errorResponse = new ResourcesException(
                status,
                ex.getMessage(),
                request.getDescription(false).replace("uri=", "")
        );

        return new ResponseEntity<>(errorResponse, status);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResourcesException> handleGlobalException(
            Exception ex,
            WebRequest request) {

        ex.printStackTrace();

        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        ResourcesException errorResponse = new ResourcesException(
                status,
                "Unexpected error ocurred. Try again later.",
                request.getDescription(false).replace("uri=", "")
        );

        return new ResponseEntity<>(errorResponse, status);
    }
}