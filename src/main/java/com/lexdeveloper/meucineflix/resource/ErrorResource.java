package com.lexdeveloper.meucineflix.resource;

import com.lexdeveloper.meucineflix.dto.response.ErrorMessage;
import com.lexdeveloper.meucineflix.exception.NotFoundException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ErrorResource extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage resourceNotFound(Exception ex, WebRequest req){
        return new ErrorMessage(404, ex.getLocalizedMessage(), "Not found", "Resource Not Found Exception");
    }

    @ExceptionHandler(Exception.class)
    public ErrorMessage exceptionResource(Exception ex, WebRequest req){
        return new ErrorMessage(500, ex.getLocalizedMessage(), "Internal Server Error","Internal Server Error Exception");
    }
}
