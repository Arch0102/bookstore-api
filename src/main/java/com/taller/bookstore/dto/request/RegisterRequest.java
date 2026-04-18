package com.taller.bookstore.dto.request;

import com.taller.bookstore.entity.Role;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class RegisterRequest {

    @NotBlank(message = "name: must not be blank")
    private String name;

    @NotBlank(message = "email: must not be blank")
    @Email(message = "email: must be a valid email address")
    private String email;

    @NotBlank(message = "password: must not be blank")
    @Size(min = 8, message = "password: must have at least 8 characters")
    private String password;

    @Builder.Default
    private Role role = Role.ROLE_USER;
}