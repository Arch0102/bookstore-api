package com.taller.bookstore.controller;

import com.taller.bookstore.dto.request.BookRequest;
import com.taller.bookstore.dto.response.ApiResponse;
import com.taller.bookstore.dto.response.BookResponse;
import com.taller.bookstore.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping
    public ResponseEntity<ApiResponse<BookResponse>> create(
            @Valid @RequestBody BookRequest request) {
        BookResponse book = bookService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success(book, "Book created successfully", 201));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<BookResponse>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(
                ApiResponse.success(bookService.getById(id), "Book found", 200));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<Page<BookResponse>>> getAll(
            @RequestParam(required = false) Long authorId,
            @RequestParam(required = false) Long categoryId,
            Pageable pageable) {

        if (authorId != null) {
            return ResponseEntity.ok(
                    ApiResponse.success(bookService.getByAuthor(authorId, pageable),
                            "Books retrieved by author", 200));
        }
        if (categoryId != null) {
            return ResponseEntity.ok(
                    ApiResponse.success(bookService.getByCategory(categoryId, pageable),
                            "Books retrieved by category", 200));
        }
        return ResponseEntity.ok(
                ApiResponse.success(bookService.getAll(pageable), "Books retrieved", 200));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<BookResponse>> update(
            @PathVariable Long id,
            @Valid @RequestBody BookRequest request) {
        return ResponseEntity.ok(
                ApiResponse.success(bookService.update(id, request), "Book updated", 200));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id) {
        bookService.delete(id);
        return ResponseEntity.ok(
                ApiResponse.success(null, "Book deleted successfully", 200));
    }
}