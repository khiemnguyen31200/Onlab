package vn.techmaster.todolist.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.techmaster.todolist.model.Todo;
import vn.techmaster.todolist.request.CreateTodoRequest;
import vn.techmaster.todolist.request.UpdateTodoRequest;
import vn.techmaster.todolist.service.TodoService;

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
