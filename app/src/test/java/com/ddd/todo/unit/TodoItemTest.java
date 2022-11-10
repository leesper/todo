package com.ddd.todo.unit;

import com.ddd.todo.domain.TodoItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TodoItemTest {
    @Test
    public void shouldNewlyCreatedTodoItemToBeNotDone() {
        TodoItem item = new TodoItem("item1");
        assertFalse(item.getDone());
    }

    @Test
    public void shouldReturnTrueWhenTodoItemSetDoneToTrue() {
        TodoItem item = new TodoItem("item2");
        item.setDone(true);
        assertTrue(item.getDone());
    }
}
