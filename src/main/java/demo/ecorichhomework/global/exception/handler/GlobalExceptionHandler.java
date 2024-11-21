package demo.ecorichhomework.global.exception.handler;

import demo.ecorichhomework.global.exception.ApiExceptionResponse;
import demo.ecorichhomework.global.exception.exceptions.ItemNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    // === 400 ===
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public ApiExceptionResponse IllegalArgumentException(IllegalArgumentException exception) {
        log.warn("IllegalArgumentException: {}", exception.getMessage());
        return new ApiExceptionResponse(HttpStatus.BAD_REQUEST, exception.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalStateException.class)
    public ApiExceptionResponse IllegalStateException(IllegalStateException exception) {
        log.warn("IllegalStateException: {}", exception.getMessage());
        return new ApiExceptionResponse(HttpStatus.BAD_REQUEST, exception.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HandlerMethodValidationException.class)
    public ApiExceptionResponse HandlerMethodValidationException(HandlerMethodValidationException exception) {
        log.warn("HandlerMethodValidationException: {}", exception.getMessage());
        String message = "Validation 실패";

        Object[] arguments = exception.getDetailMessageArguments();
        if (!Objects.isNull(arguments)) {
            List<Object> argumentList = Arrays.stream(arguments).toList();
            if (!argumentList.isEmpty()) {
                message = argumentList.getFirst().toString();
            }
        }

        return new ApiExceptionResponse(HttpStatus.BAD_REQUEST, message);
    }

    // === 404 ===
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ItemNotFoundException.class)
    public ApiExceptionResponse ItemNotFoundException(ItemNotFoundException exception) {
        log.warn("ItemNotFoundException: {}", exception.getMessage());
        return new ApiExceptionResponse(HttpStatus.NOT_FOUND, exception.getMessage());
    }

    // === 500 ===
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RuntimeException.class)
    public ApiExceptionResponse handleGlobalException(RuntimeException e) {
        log.error("RuntimeException: {}", e.getMessage());
        return new ApiExceptionResponse(HttpStatus.INTERNAL_SERVER_ERROR, "서버 에러가 발생하였습니다.");
    }

}
