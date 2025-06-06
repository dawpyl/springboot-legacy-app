package com.example.todo;

import com.example.todo.entity.TodoItem;
import com.example.todo.repository.TodoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class TodoTests {

    @Autowired
    private TodoRepository repository;

    @Test
    public void testCreateAndFindTodo() {
        TodoItem item = new TodoItem();
        item.setTitle("Test Task");
        item.setCompleted(false);
        TodoItem saved = repository.save(item);
        assertThat(repository.findById(saved.getId())).isPresent();
    }
}
