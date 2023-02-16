package com.example.ecommerce.exception;

public class InvalidPermissionException extends RuntimeException{
    public InvalidPermissionException() {
        super("You do not have the necessary permission to perform this action.");
    }
}
