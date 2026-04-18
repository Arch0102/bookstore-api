package com.taller.bookstore.exception.custom;

public class InsufficientStockException extends RuntimeException {
    public InsufficientStockException(String bookTitle, int available) {
        super("Insufficient stock for '" + bookTitle + "'. Available: " + available);
    }
}