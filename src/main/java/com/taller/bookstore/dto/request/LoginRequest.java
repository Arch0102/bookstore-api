package com.taller.bookstore.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginRequest {

    @NotBlank(message = "email: must not be blank")
    @Email(message = "email: must be a valid email address")
    private String email;

    @NotBlank(message = "password: must not be blank")
    private String password;
}