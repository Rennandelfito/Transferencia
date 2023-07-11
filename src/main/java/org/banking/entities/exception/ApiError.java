package org.banking.entities.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
public class ApiError {
    String message;
    LocalDateTime timestamp;
    HttpStatus status;

    public ApiError(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
        this.timestamp = LocalDateTime.now();
    }
    }
