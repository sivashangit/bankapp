package com.exam.BankApp.advice;

import com.exam.BankApp.dto.Response;
import com.exam.BankApp.exception.AccountNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class exceptionadvice {

    /*@ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<String> handleAccountNotFounDException(AccountNotFoundException exception){

        String message="Message===>"+exception.getMessage()+"Id====>"+exception.getAccId();
        return new ResponseEntity<>("Message===>"+message, HttpStatus.NOT_FOUND);

    }*/

    @ExceptionHandler(AccountNotFoundException.class)
    public Response<?> handleAccountNotFounDException(AccountNotFoundException exception){

        Response<?> response=new Response<>();
        response.setMessage(exception.getMessage());
        response.setCode(exception.getAccId());
        return response;
    }


}
