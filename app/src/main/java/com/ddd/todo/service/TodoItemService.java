package com.ddd.todo.service;

import com.ddd.todo.domain.TodoItem;
import com.ddd.todo.repository.TodoItemRepository;

import java.util.List;
import java.util.stream.Collectors;

public class TodoItemService {
    private TodoItemRepository repository;
    public TodoItemService(TodoItemRepository repo) {
        repository = repo;
    }

    public void addItem(TodoItem item) {
        repository.add(item);
    }

    public void done(int i) {
        TodoItem item = repository.get(i);
        item.setDone(true);
        repository.save(item);
    }

    public List<TodoItem> list(boolean all) {
        List<TodoItem> items = repository.list();
        if (!all) {
            return items.stream().filter(i -> !i.getDone()).collect(Collectors.toList());
        }
        return items;
    }
}
