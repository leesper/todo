package com.ddd.todo.unit;

import com.ddd.todo.domain.TodoItem;
import com.ddd.todo.repository.TodoItemRepository;

import java.util.ArrayList;
import java.util.List;

public class TodoItemFakeRepository implements TodoItemRepository {
    private List<TodoItem> items = new ArrayList<>();

    @Override
    public void add(TodoItem item) {
        item.setIndex(items.size() + 1);
        items.add(item);
    }

    @Override
    public TodoItem get(int index) {
        return items.get(index-1);
    }

    @Override
    public void save(TodoItem item, int index) {
        if (1 <= index && index <= items.size()) {
            items.set(index - 1, item);
        }

    }

    @Override
    public List<TodoItem> list() {
        return items;
    }
}
