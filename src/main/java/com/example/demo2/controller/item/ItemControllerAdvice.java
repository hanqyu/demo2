package com.example.demo2.controller.item;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class ItemControllerAdvice {

    @ExceptionHandler({NoSuchElementException.class, IllegalArgumentException.class})
    public ResponseEntity noSuchElementExceptionHandler(RuntimeException e) {
        return (ResponseEntity) ResponseEntity.notFound();
    }
}
