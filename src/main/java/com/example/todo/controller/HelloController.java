package com.example.todo.controller;

import com.example.todo.entity.TodoItem;
import com.example.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class HelloController {
    @Autowired
    private TodoService service;

    @GetMapping
    public Iterable<TodoItem> getAll() {
        return service.findAll();
    }

    @PostMapping
    public TodoItem create(@RequestBody TodoItem item) {
        return service.save(item);
    }
}
