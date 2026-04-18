package com.taller.bookstore.dto.response;

import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiErrorResponse {

    private String status;
    private int code;
    private String message;
    private List<String> errors;
    private LocalDateTime timestamp;
    private String path;

    public static ApiErrorResponse of(int code, String message, List<String> errors, String path) {
        return ApiErrorResponse.builder()
                .status("error")
                .code(code)
                .message(message)
                .errors(errors)
                .timestamp(LocalDateTime.now())
                .path(path)
                .build();
    }
}