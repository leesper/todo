package com.ddd.todo.repository;

import com.ddd.todo.domain.TodoItem;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.util.List;
import java.util.Objects;

public class TodoItemJsonRepository implements TodoItemRepository {
    private ObjectMapper objectMapper = new ObjectMapper();
    private final String JSON_FILE = "todo_data.json";

    @Override
    public void add(TodoItem item) {
        List<TodoItem> items = loadItems();
        item.setIndex(items.size() + 1);
        items.add(item);
        saveItems(items);
    }
    @Override
    public TodoItem get(int index) {
        List<TodoItem> items = loadItems();
        return (1 <= index && index <= items.size()) ? items.get(index-1) : null;
    }

    @Override
    public void save(TodoItem item, int index) {
        List<TodoItem> todoItems = loadItems();
        if (1 <= index && index <= todoItems.size() ) {
            item.setIndex(index);
            todoItems.set(index-1, item);
            saveItems(todoItems);
        }
    }

    @Override
    public List<TodoItem> list() {
        return loadItems();
    }

    private List<TodoItem> loadItems() {
        try {
            InputStream is = this.getClass().getClassLoader().getResourceAsStream(JSON_FILE);
            List<TodoItem> items = objectMapper.readValue(is, new TypeReference<List<TodoItem>>(){});
            return items;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void saveItems(List<TodoItem> items) {
        try {
            OutputStream os = Files.newOutputStream(
                    new File(Objects.requireNonNull(
                                    getClass()
                                            .getClassLoader()
                                            .getResource(JSON_FILE))
                            .toURI()).toPath());
            objectMapper.writeValue(os, items);
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
