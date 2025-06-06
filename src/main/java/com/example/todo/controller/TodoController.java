package com.example.todo.controller;

import com.example.todo.entity.TodoItem;
import com.example.todo.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {
    private final TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<TodoItem>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    public ResponseEntity<TodoItem> create(@Valid @RequestBody TodoItem item) {
        return ResponseEntity.ok(service.save(item));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoItem> update(@PathVariable Long id, @Valid @RequestBody TodoItem item) {
        return service.update(id, item)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/complete")
    public ResponseEntity<TodoItem> toggleComplete(@PathVariable Long id) {
        return service.toggleComplete(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
