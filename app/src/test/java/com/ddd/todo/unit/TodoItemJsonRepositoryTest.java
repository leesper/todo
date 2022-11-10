package com.ddd.todo.unit;

import com.ddd.todo.domain.TodoItem;
import com.ddd.todo.repository.TodoItemJsonRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class TodoItemJsonRepositoryTest {
    @Test
    public void shouldReturnEmptyTodoItemList() {
        TodoItemJsonRepository repo = new TodoItemJsonRepository();
        List<TodoItem> items = repo.list();
        assertTrue(items.isEmpty());
    }

    @Test
    public void shouldAddItemInTodoItemList() {
        TodoItemJsonRepository repo = new TodoItemJsonRepository();
        repo.add(new TodoItem("item1"));
        List<TodoItem> items = repo.list();
        assertEquals(1, items.size());
    }

    @Test
    public void shouldGetItemInTodoItemList() {
        TodoItemJsonRepository repo = new TodoItemJsonRepository();
        repo.add(new TodoItem("item1"));
        repo.add(new TodoItem("item2"));
        repo.add(new TodoItem("item3"));

        TodoItem item2 = repo.get(2);
        assertEquals("item2", item2.getContent());
        TodoItem notExist = repo.get(4);
        assertNull(notExist);
    }

    @Test
    public void shouldSaveItemAtSpecificIndex() {
        TodoItemJsonRepository repo = new TodoItemJsonRepository();
        repo.add(new TodoItem("item1"));
        repo.add(new TodoItem("item2"));
        repo.add(new TodoItem("item3"));

        TodoItem item = new TodoItem("new Item2");
        repo.save(item, 2);
        TodoItem retrieved = repo.get(2);

        assertEquals("new Item2", retrieved.getContent());
        assertEquals(2, retrieved.getIndex());

        repo.save(item, 4);
        assertEquals(3, repo.list().size());
    }

    @AfterEach
    public void clearJsonFile() {
        try {
            OutputStream os = Files.newOutputStream(
                    new File(Objects.requireNonNull(
                                    getClass()
                                            .getClassLoader()
                                            .getResource("todo_data.json"))
                            .toURI()).toPath());
            os.write("[]".getBytes());
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }

    }
}
