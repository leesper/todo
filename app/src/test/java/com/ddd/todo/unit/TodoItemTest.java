package com.ddd.todo.unit;

import com.ddd.todo.domain.TodoItem;
import org.junit.Assert;
import org.junit.Test;

public class TodoItemTest {
    @Test
    public void shouldNewlyCreatedTodoItemToBeNotDone() {
        TodoItem item = new TodoItem(1, "item1");
        Assert.assertFalse(item.getDone());
    }

    @Test
    public void shouldReturnTrueWhenTodoItemSetDoneToTrue() {
        TodoItem item = new TodoItem(1, "item2");
        item.setDone(true);
        Assert.assertTrue(item.getDone());
    }
}
