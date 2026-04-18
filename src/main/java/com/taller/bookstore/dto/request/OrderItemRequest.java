package com.taller.bookstore.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class OrderItemRequest {

    @NotNull(message = "bookId: must not be null")
    private Long bookId;

    @NotNull(message = "quantity: must not be null")
    @Min(value = 1, message = "quantity: must be greater than 0")
    private Integer quantity;
}