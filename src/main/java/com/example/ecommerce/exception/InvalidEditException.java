package com.example.ecommerce.exception;

public class InvalidEditException extends RuntimeException{
    public InvalidEditException(String message) {
        super(message);
    }
}
