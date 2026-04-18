package com.taller.bookstore.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookRequest {

    @NotBlank(message = "title: must not be blank")
    @Size(max = 200, message = "title: must have at most 200 characters")
    private String title;

    @NotBlank(message = "isbn: must not be blank")
    private String isbn;

    @NotNull(message = "price: must not be null")
    @DecimalMin(value = "0.01", message = "price: must be greater than 0")
    private BigDecimal price;

    @NotNull(message = "stock: must not be null")
    @Min(value = 0, message = "stock: must be greater than or equal to 0")
    private Integer stock;

    @NotNull(message = "authorId: must not be null")
    private Long authorId;

    private List<Long> categoryIds;
}