package com.mama.union.utils.exeption;

import com.mama.union.utils.security.SecurityUser;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.*;

@ResponseBody
@ControllerAdvice
public class ErrorControllerAdvice {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(PersonNotFoundExeption.class)
    public ErrorResponse handleExeption(PersonNotFoundExeption e) {
        return new ErrorResponse(e.getMessage());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundExeption.class)
    public ErrorResponse handleExeption(UserNotFoundExeption e) {
        return new ErrorResponse(e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse handleExeption(MethodArgumentNotValidException e) {

        String message = e.getParameter().getExecutable().toGenericString();
//        String message = e.getBindingResult().toString();

        SecurityUser user = (SecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String data = new Date().toString();
        String path = e.getParameter().getParameterType().toString();

        Map<String, String> errors = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return new ErrorResponse(message, user.getUsername(), data, path, errors);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public ErrorResponse handleExeption(ConstraintViolationException e) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", new Date());

        String message = e.toString();

        Map<String, String> errors = new HashMap<>();
        Set<ConstraintViolation<?>> er = e.getConstraintViolations();
        for (ConstraintViolation<?> c : er) {
            String path = c.getPropertyPath().toString();
            String errorMessage = c.getMessage();
            errors.put("path", path);
            errors.put("errorMessage", errorMessage);
        }

        return new ErrorResponse(message, errors);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MyOwnExeprion.class)
    public ErrorResponse handleExeption(MyOwnExeprion e) {

        Map<String, String> body = new HashMap<>();

        for (ObjectError o : e.getErrorsList()) {
            String fieldName = o.getCodes()[1];
            String message = o.getDefaultMessage();

            body.put(fieldName, message);
        }
        return new ErrorResponse(e.getErrorsList().toString(), body);
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(AuthenticationException.class)
    public ErrorResponse handleExeption(AuthenticationException e) {
        return new ErrorResponse(e.getMessage());
    }
}
