package com.ddd.todo.unit;

import com.ddd.todo.domain.TodoItem;
import com.ddd.todo.repository.TodoItemRepository;
import com.ddd.todo.service.TodoItemService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TodoItemServiceTest {
    @Test
    public void shouldAddTodoItem() {
        TodoItemRepository repo = new TodoItemFakeRepository();
        TodoItemService service = new TodoItemService(repo);
        TodoItem item = new TodoItem("item 1");
        service.addItem(item);
        TodoItem sameItem = repo.get(1);
        item.setIndex(1);
        assertEquals(sameItem, item);
    }

    @Test
    public void shouldIncreaseIndexByOne() {
        TodoItem item1 = new TodoItem("item1");
        TodoItem item2 = new TodoItem("item2");
        TodoItemRepository repo = new TodoItemFakeRepository();
        TodoItemService service = new TodoItemService(repo);
        service.addItem(item1);
        service.addItem(item2);
        TodoItem sameItem1 = repo.get(1);
        TodoItem sameItem2 = repo.get(2);

        assertEquals(1, sameItem1.getIndex());
        assertEquals(2, sameItem2.getIndex());
    }

    @Test
    public void shouldMarkTodoItemDone() {
        TodoItem item = new TodoItem("item");
        TodoItemRepository repo = new TodoItemFakeRepository();
        TodoItemService service = new TodoItemService(repo);
        service.addItem(item);
        service.done(1);
        TodoItem sameItem = repo.get(1);
        assertTrue(sameItem.getDone());
    }

    @Test
    public void shouldListUndoneTodoItems() {
        TodoItem item1 = new TodoItem("item1");
        TodoItem item2 = new TodoItem("item2");
        TodoItem item3 = new TodoItem("item3");
        TodoItem item4 = new TodoItem("item4");
        TodoItemRepository repo = new TodoItemFakeRepository();
        TodoItemService service = new TodoItemService(repo);
        service.addItem(item1);
        service.addItem(item2);
        service.addItem(item3);
        service.addItem(item4);
        service.done(4);

        List<TodoItem> items = service.list(false);
        assertEquals(3, items.size());
    }

    @Test
    public void shouldListAllTodoItems() {
        TodoItem item1 = new TodoItem("item1");
        TodoItem item2 = new TodoItem("item2");
        TodoItem item3 = new TodoItem("item3");
        TodoItem item4 = new TodoItem("item4");
        TodoItemRepository repo = new TodoItemFakeRepository();
        TodoItemService service = new TodoItemService(repo);
        service.addItem(item1);
        service.addItem(item2);
        service.addItem(item3);
        service.addItem(item4);
        service.done(4);

        List<TodoItem> items = service.list(true);
        assertEquals(4, items.size());
    }
}
