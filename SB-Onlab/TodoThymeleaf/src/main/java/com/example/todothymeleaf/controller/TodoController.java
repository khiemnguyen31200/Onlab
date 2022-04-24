package com.example.todothymeleaf.controller;

import com.example.todothymeleaf.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.todothymeleaf.model.Todo;
import com.example.todothymeleaf.request.CreateTodoRequest;
import com.example.todothymeleaf.request.UpdateTodoRequest;
import com.example.todothymeleaf.service.TodoService;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TodoController {
    @Autowired
    TodoService todoService;

    @GetMapping("/todos")
    public ResponseEntity<?> getAll(@RequestParam(required = false, defaultValue = "")String status){
        List<Todo> todos = todoService.getTodos(status);
        return ResponseEntity.ok(todos);
    }
    @PostMapping("/todos")
    public ResponseEntity<?> createTodo(@RequestBody CreateTodoRequest request){
        Todo todo = todoService.createTodo(request);
        return ResponseEntity.ok(todo);
    }
    @PutMapping("/todos/{id}")
    public ResponseEntity<?> updateTodo(@PathVariable int id,@RequestBody UpdateTodoRequest request){
        Todo todo = todoService.updateTodo(id,request);
        return ResponseEntity.ok(todo);
    }
    @DeleteMapping("/todos/{id}")
    public ResponseEntity<?> deleteTodo(@PathVariable int id){
        todoService.deleteTodo(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
