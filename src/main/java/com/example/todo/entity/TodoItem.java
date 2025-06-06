package com.example.todo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "todo_items")
public class TodoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Title is required")
    private String title;

    private boolean completed;

    // Konstruktor bezargumentowy dla JPA i testów
    public TodoItem() {}

    // Konstruktor z wymaganymi polami
    public TodoItem(String title) {
        this.title = title;
        this.completed = false;
    }

    // Gettery i settery
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
