package com.ddd.todo.repository;

import com.ddd.todo.domain.TodoItem;

import java.util.List;

public interface TodoItemRepository {
    void add(TodoItem item);
    TodoItem get(int index);
    
    void save(TodoItem item);

    List<TodoItem> list();
}
