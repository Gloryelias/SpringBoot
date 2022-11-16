package com.student.ust.exception;

public class BusinessException extends RuntimeException{
    public BusinessException(String exception){
        super("invalid_email_format");
    }


}
