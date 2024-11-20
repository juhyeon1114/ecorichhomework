package demo.ecorichhomework.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class ApiExceptionResponse {

    public HttpStatus code;
    public String message;

}
