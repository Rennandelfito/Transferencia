package org.banking.controller.handler;

import org.banking.entities.exception.ApiError;
import org.banking.entities.exception.TransferValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandlerExceptionController {
    @ExceptionHandler(TransferValidationException.class)
    ResponseEntity<ApiError> errorTransfer(TransferValidationException ex) {
return ResponseEntity.badRequest().body(new ApiError(ex.getMessage(), HttpStatus.BAD_REQUEST));
    }
}
