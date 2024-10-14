package org.example.coffeeshopposspringbackend.exception;

public class ProductNotFound extends RuntimeException{
    public ProductNotFound(){}
    public ProductNotFound(String message){}
    public ProductNotFound(String message, Throwable cause) {
    }
}
