package com.taller.bookstore.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;

import java.util.List;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class OrderRequest {

    @NotEmpty(message = "items: must not be empty")
    private List<OrderItemRequest> items;
}