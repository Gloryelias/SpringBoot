package com.student.ust.exception;

public class InvalidPasswordException extends  BusinessException{
    public InvalidPasswordException(){
        super("Invalid Password");
    }
}
