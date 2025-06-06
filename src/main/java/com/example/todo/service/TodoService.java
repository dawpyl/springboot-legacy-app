package com.example.todo.service;

import com.example.todo.entity.TodoItem;
import com.example.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    @Autowired
    private TodoRepository repository;

    public Iterable<TodoItem> findAll() {
        return repository.findAll();
    }

    public TodoItem save(TodoItem item) {
        return repository.save(item);
    }
}
