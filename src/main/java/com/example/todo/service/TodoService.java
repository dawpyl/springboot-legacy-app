package com.example.todo.service;

import com.example.todo.entity.TodoItem;
import com.example.todo.repository.TodoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TodoService {
    private final TodoRepository repository;

    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    public List<TodoItem> findAll() {
        return repository.findAll();
    }

    public TodoItem save(TodoItem item) {
        return repository.save(item);
    }

    public Optional<TodoItem> update(Long id, TodoItem item) {
        return repository.findById(id)
            .map(existingItem -> {
                existingItem.setTitle(item.getTitle());
                existingItem.setCompleted(item.isCompleted());
                return repository.save(existingItem);
            });
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Optional<TodoItem> toggleComplete(Long id) {
        return repository.findById(id)
            .map(item -> {
                item.setCompleted(!item.isCompleted());
                return repository.save(item);
            });
    }
}
