package com.example.rewardpoints.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    // Handle specific ResourceNotFoundException with 404
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException ex) {
        logger.error("Resource not found: " + ex.getMessage(), ex);
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    // Handle IllegalArgumentException or BadRequestException with 400
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleBadRequestException(IllegalArgumentException ex) {
        logger.error("Bad request: " + ex.getMessage(), ex);
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    // Handle all other exceptions with 500
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralException(Exception ex) {
        logger.error("An error occurred: " + ex.getMessage(), ex);
        return new ResponseEntity<>("An unexpected error occurred. Please try again.", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
