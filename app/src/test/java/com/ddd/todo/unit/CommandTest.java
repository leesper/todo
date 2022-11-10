package com.ddd.todo.unit;

import com.ddd.todo.entrypoint.Command;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CommandTest {
    @Test
    public void shouldParseAddCommand() {
        String[] args = {"add", "item1"};
        Command command = new Command(args);
        assertEquals("add", command.cmd());
        assertNull(command.flag());
        assertEquals("item1", command.arg());
    }

    @Test
    public void shouldParseDoneCommand() {
        String[] args = {"done", "1"};
        Command command = new Command(args);
        assertEquals("done", command.cmd());
        assertNull(command.flag());
        assertEquals("1", command.arg());
    }

    @Test
    public void shouldParseListCommand() {
        String[] args = {"list"};
        Command command = new Command(args);
        assertEquals("list", command.cmd());
        assertNull(command.flag());
        assertNull(command.arg());
    }

    @Test
    public void shouldParseListCommandWthAll() {
        String[] args = {"list", "--all"};
        Command command = new Command(args);
        assertEquals("list", command.cmd());
        assertEquals("--all", command.flag());
        assertEquals(null, command.arg());
    }
}
