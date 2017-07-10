package com.app.packs.web.rest.error.advice;

import java.nio.file.AccessDeniedException;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.packs.web.rest.error.dto.ErrorDTO;


@RestControllerAdvice
public class ErrorHandler {
	
	@ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorDTO badRequest(IllegalArgumentException ex) {
        return new ErrorDTO("Bad Request", ex.getMessage());
    }
	
	@ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public ErrorDTO unauthorized(AccessDeniedException ex) {
        return new ErrorDTO("unauthorized", ex.getMessage());
    }
	@ExceptionHandler(DuplicateKeyException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorDTO duplicate(DuplicateKeyException ex) {
        return new ErrorDTO("duplicate", ex.getMessage());
    }
	

}
