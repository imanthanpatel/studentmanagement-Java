package com.example.StudentManagementSystem.exception;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.csrf.CsrfException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class GlobalExceptionHandler {

    private  static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(CsrfException.class)
    public String csrfExceptionHandler(CsrfException ex,RedirectAttributes redirectAttributes){
        log.warn("CSRF Validation Failed", ex.getMessage());
        redirectAttributes.addFlashAttribute("Msg","Session expired Please login again....");
        return "redirect:/login";
    }
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String GenricExceptionHandler(Exception exception){
        log.warn("Somthing Went Wrong", exception);
        return "500";
    }

    @ExceptionHandler(UserNotFoundException.class)
    public String UerNotFoundException(UserNotFoundException userNotFoundException){
    return userNotFoundException.getMessage();
    }
}