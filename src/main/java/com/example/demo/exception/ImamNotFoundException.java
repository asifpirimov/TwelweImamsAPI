package com.example.demo.exception;

public class ImamNotFoundException extends RuntimeException{
    public ImamNotFoundException(Long id) {
        super("Info about Imam not found : " + id); 
    }

}
