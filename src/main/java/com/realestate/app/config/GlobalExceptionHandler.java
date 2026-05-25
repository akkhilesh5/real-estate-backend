package com.realestate.app.config;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.MethodArgumentNotValidException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        String errorMessages = result.getFieldErrors()
                                      .stream()
                                      .map(fieldError -> fieldError.getField() + ": " + fieldError.getDefaultMessage())
                                      .reduce((e1, e2) -> e1 + ", " + e2)
                                      .orElse("Validation failed");

        return new ResponseEntity<>("Validation failed: " + errorMessages, HttpStatus.BAD_REQUEST);
    }
    
   
}
