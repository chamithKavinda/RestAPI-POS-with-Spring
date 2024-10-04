package org.example.coffeeshopposspringbackend.exception;

public class CustomerNotFound extends RuntimeException{
    public CustomerNotFound(){}
    public CustomerNotFound(String message){}
    public CustomerNotFound(String message, Throwable cause) {
    }
}
