package demo.ecorichhomework.global.exception.handler;

import demo.ecorichhomework.global.exception.ApiExceptionResponse;
import demo.ecorichhomework.global.exception.exceptions.ItemNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    // === 400 ===
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public ApiExceptionResponse IllegalArgumentException(IllegalArgumentException exception) {
        return new ApiExceptionResponse(HttpStatus.BAD_REQUEST, exception.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalStateException.class)
    public ApiExceptionResponse IllegalStateException(IllegalStateException exception) {
        return new ApiExceptionResponse(HttpStatus.BAD_REQUEST, exception.getMessage());
    }

    // === 404 ===
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ItemNotFoundException.class)
    public ApiExceptionResponse ItemNotFoundException(ItemNotFoundException exception) {
        return new ApiExceptionResponse(HttpStatus.NOT_FOUND, exception.getMessage());
    }

}
