package com.example.todo.repository;

import com.example.todo.entity.TodoItem;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<TodoItem, Long> {
}
