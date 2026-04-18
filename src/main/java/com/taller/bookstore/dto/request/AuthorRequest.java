package com.taller.bookstore.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthorRequest {

    @NotBlank(message = "name: must not be blank")
    private String name;

    private String biography;

    @Email(message = "contactEmail: must be a valid email address")
    private String contactEmail;
}