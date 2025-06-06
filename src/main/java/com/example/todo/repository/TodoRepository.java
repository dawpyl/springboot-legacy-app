package com.example.todo.repository;

import com.example.todo.entity.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface TodoRepository extends JpaRepository<TodoItem, Long> {
    List<TodoItem> findByCompleted(boolean completed);

    @Query("SELECT t FROM TodoItem t WHERE LOWER(t.title) LIKE LOWER(CONCAT('%', :query, '%'))")
    List<TodoItem> searchByTitle(String query);
}
