package ru.nikolaev.bank.controller.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.nikolaev.bank.utils.exception.ApplicationException;
import ru.nikolaev.bank.utils.exception.NotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handleClientNotFoundException(NotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse(
                "Not Found",
                ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<?> handleClientNotFoundException(ApplicationException ex) {
        ErrorResponse errorResponse = new ErrorResponse(
                "Bad Request",
                ex.getMessage());
        return ResponseEntity.badRequest().body(errorResponse);
    }

    @Getter
    @Setter
    @AllArgsConstructor
    private static class ErrorResponse {
        private final String error;
        private final String message;
    }
}


