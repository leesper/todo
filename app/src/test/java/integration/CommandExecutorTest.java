package integration;

import com.ddd.todo.entrypoint.Command;
import com.ddd.todo.entrypoint.CommandExecutor;
import com.ddd.todo.service.TodoItemService;
import com.ddd.todo.unit.TodoItemFakeRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandExecutorTest {
    // Add
    @Test
    public void shouldAddItemAndReturnResult() {
        CommandExecutor executor = new
                CommandExecutor(new TodoItemService(new TodoItemFakeRepository()));
        String result = executor.execute(new Command(new String[]{"add", "item1"}));
        String expected = "1. item1\nItem 1 added\n";
        assertEquals(expected, result);

        result = executor.execute(new Command(new String[]{"add", "item2"}));
        expected = "2. item2\nItem 2 added\n";
        assertEquals(expected, result);
    }

    // Done
    @Test
    public void shouldMarkItemAsDoneAndReturnResult() {
        CommandExecutor executor = new
                CommandExecutor(new TodoItemService(new TodoItemFakeRepository()));
        executor.execute(new Command(new String[]{"add", "item1"}));
        String result = executor.execute(new Command(new String[]{"done", "1"}));
        String expected = "Item 1 done\n";
        assertEquals(expected, result);
    }

    // List
    @Test
    public void shouldListUndoneItemsAsResult() {
        CommandExecutor executor = new
                CommandExecutor(new TodoItemService(new TodoItemFakeRepository()));
        executor.execute(new Command(new String[]{"add", "item1"}));
        executor.execute(new Command(new String[]{"add", "item2"}));
        executor.execute(new Command(new String[]{"add", "item3"}));
        executor.execute(new Command(new String[]{"add", "item4"}));
        executor.execute(new Command(new String[]{"done", "2"}));

        String result = executor.execute(new Command(new String[]{"list"}));
        String expected = "1. item1\n3. item3\n4. item4\nTotal: 3 items\n";
        assertEquals(expected, result);
    }

    // List all
    @Test
    public void shouldListAllItemsAsResult() {
        CommandExecutor executor = new
                CommandExecutor(new TodoItemService(new TodoItemFakeRepository()));
        executor.execute(new Command(new String[]{"add", "item1"}));
        executor.execute(new Command(new String[]{"add", "item2"}));
        executor.execute(new Command(new String[]{"add", "item3"}));
        executor.execute(new Command(new String[]{"add", "item4"}));
        executor.execute(new Command(new String[]{"done", "2"}));

        String result = executor.execute(new Command(new String[]{"list", "--all"}));
        String expected = "1. item1\n2. [Done] item2\n3. item3\n4. item4\nTotal: 4 items, 1 item done\n";
        assertEquals(expected, result);
    }
}
