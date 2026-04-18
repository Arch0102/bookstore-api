package com.taller.bookstore.exception.custom;

public class AuthorHasBooksException extends RuntimeException {
    public AuthorHasBooksException(Long authorId) {
        super("Author with id " + authorId + " has books associated and cannot be deleted");
    }
}