package com.student.ust.exception;

public class InvalidEmailException extends BusinessException{
    public InvalidEmailException(){
        super("Invalid email format");
    }
}
