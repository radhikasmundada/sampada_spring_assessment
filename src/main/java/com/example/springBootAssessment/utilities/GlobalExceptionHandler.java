package com.example.springBootAssessment.utilities;

import com.example.springBootAssessment.exceptions.EntityAlreadyExistException;
import com.example.springBootAssessment.exceptions.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<Object> handleEntityNotFound(EntityNotFoundException entityNotFoundException){
        Map<String, Object> response = new HashMap<>();
        response.put("message", entityNotFoundException.getMessage());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler({EntityAlreadyExistException.class})
    public ResponseEntity<Object> handleEntityAlreadyExist(EntityAlreadyExistException entityAlreadyExist){
        Map<String, Object> response = new HashMap<>();
        response.put("message", entityAlreadyExist.getMessage());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}

