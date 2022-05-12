/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cim.typeA.controller.advice;

import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *
 * @author HP
 */

@ControllerAdvice
@Slf4j
public class ValidationExceptionHandler {

@ExceptionHandler(MethodArgumentNotValidException.class)
public ResponseEntity<?> handleValidationExceptions(MethodArgumentNotValidException exception){
   // Map<String, String> errors = new HashMap<>();
exception.getBindingResult().getAllErrors().forEach((error)-> {
String fieldName = ((FieldError) error).getField();
String errorMessage = error.getDefaultMessage();
log.error(fieldName + ": " +errorMessage);
//errors.put(fieldName, errorMessage);
}) ;
        return ResponseEntity.badRequest().body("error Message");
}
    
}
