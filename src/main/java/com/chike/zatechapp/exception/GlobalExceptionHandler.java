package com.chike.zatechapp.exception;

import com.chike.zatechapp.dto.AppResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ResponseBody
    @ExceptionHandler(AppException.class)
    @ResponseStatus(HttpStatus.OK)
    AppResponse dataNotFoundHandler(AppException ex) {
        return new AppResponse(false,ex.getMessage(),null);
    }
}
