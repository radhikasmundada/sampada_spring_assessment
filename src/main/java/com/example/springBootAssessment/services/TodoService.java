package com.example.springBootAssessment.services;

import com.example.springBootAssessment.exceptions.EntityAlreadyExistException;
import com.example.springBootAssessment.exceptions.EntityNotFoundException;
import com.example.springBootAssessment.models.Todo;
import com.example.springBootAssessment.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> getAll(){
        return todoRepository.findAll();
    }

    public Todo getItem(Long id){
        Optional<Todo> todo = todoRepository.findById(id);
        if(todo.isPresent()){
            return todo.get();
        }
        throw new EntityNotFoundException("todo with given ID does not exist");
    }

    public String delete(Long id){
        if(todoRepository.findById(id).isPresent()){
            todoRepository.deleteById(id);
            return "todo deleted successfully";
        }
        throw new EntityNotFoundException("Unable to delete todo as ID doesn't exist");

    }

    public Object create(Todo todo) {
        if(todoRepository.findByTitle(todo.getTitle()).isEmpty()){
            return todoRepository.save(todo);
        }
        throw new EntityAlreadyExistException("todo already exist");
    }

    public Object update(Todo todo) {

        Optional<Todo> todoOptional = todoRepository.findById(todo.getId());
        if (todoOptional.isPresent()) {
            todoOptional.get().setStatus(todo.getStatus());
            todoOptional.get().setTitle(todo.getTitle());
            todoOptional.get().setDescription(todo.getDescription());

            return todoRepository.save(todoOptional.get());
        }
        throw new EntityNotFoundException("Unable to update todo as ID doesn't exist");
    }

}
