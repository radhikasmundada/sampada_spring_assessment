package com.example.springBootAssessment.controllers;

import com.example.springBootAssessment.models.Todo;
import com.example.springBootAssessment.services.TodoService;
import com.example.springBootAssessment.utilities.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/todos")
public class TodoController {

     @Autowired
     private TodoService todoService;


     @GetMapping("/")
     public ResponseEntity<Object> getAll(){
          return ResponseHandler.createResponse("Found todos", HttpStatus.OK, todoService.getAll());
     }

     @GetMapping("/{id}")
     public ResponseEntity<Object> getItem(@PathVariable Long id){
          return ResponseHandler.createResponse("todo found", HttpStatus.OK, todoService.getItem(id));
     }

     @DeleteMapping("/delete/{id}")
     public ResponseEntity<Object> delete(@PathVariable Long id){
          return ResponseHandler.createResponse("todo deleted", HttpStatus.OK, todoService.delete(id));
     }

     @PostMapping("/add")
     public ResponseEntity<Object> create(@RequestBody Todo todo){
          return ResponseHandler.createResponse("todo added", HttpStatus.CREATED, todoService.create(todo));
     }

     @PutMapping("/updateTodo")
     public  Object update(@RequestBody Todo todo){
          return ResponseHandler.createResponse("todo updated", HttpStatus.OK, todoService.update(todo));
     }
}
