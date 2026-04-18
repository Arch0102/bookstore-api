package com.taller.bookstore.mapper;

import com.taller.bookstore.dto.request.BookRequest;
import com.taller.bookstore.dto.response.BookResponse;
import com.taller.bookstore.entity.Author;
import com.taller.bookstore.entity.Book;
import com.taller.bookstore.entity.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
@RequiredArgsConstructor
public class BookMapper {

    private final AuthorMapper authorMapper;
    private final CategoryMapper categoryMapper;

    public Book toEntity(BookRequest request, Author author, List<Category> categories) {
        return Book.builder()
                .title(request.getTitle())
                .isbn(request.getIsbn())
                .price(request.getPrice())
                .stock(request.getStock())
                .author(author)
                .categories(categories)
                .build();
    }

    public BookResponse toResponse(Book book) {
        return BookResponse.builder()
                .id(book.getId())
                .title(book.getTitle())
                .isbn(book.getIsbn())
                .price(book.getPrice())
                .stock(book.getStock())
                .author(authorMapper.toResponse(book.getAuthor()))
                .categories(book.getCategories() != null
                        ? book.getCategories().stream()
                        .map(categoryMapper::toResponse)
                        .toList()
                        : Collections.emptyList())
                .build();
    }
}