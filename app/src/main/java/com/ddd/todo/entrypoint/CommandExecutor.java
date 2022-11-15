package com.ddd.todo.entrypoint;

import com.ddd.todo.domain.TodoItem;
import com.ddd.todo.service.TodoItemService;

import java.util.List;

public class CommandExecutor {
    // TODO: 开发一个CommandExecutor，定义execute()方法，以Command为输入，以String为输出结果
    // TODO: CommandExecutor根据Command调用TodoItemService完成相应操作，然后将结果转换成String
    private TodoItemService todoItemService;
    public CommandExecutor(TodoItemService service) {
        todoItemService = service;
    }

    public String execute(Command command) {
        String result = String.format("Unknown command: %s\n", command.cmd());
        switch (command.cmd()) {
            case "add":
                TodoItem added = todoItemService.addItem(new TodoItem(command.arg()));
                result = String.format("%d. %s\nItem %d added\n",
                        added.getIndex(), added.getContent(), added.getIndex());
                break;
            case "done":
                TodoItem done = todoItemService.done(Integer.parseInt(command.arg()));
                result = String.format("Item %d done\n", done.getIndex());
                break;
            case "list":
                List<TodoItem> items = todoItemService.list(command.flag() != null && command.flag().equals("--all"));
                StringBuilder builder = new StringBuilder();
                int countOfDone = 0;
                for (TodoItem item : items) {
                    if (item.getDone()) {
                        countOfDone++;
                    }
                    builder.append(String.format("%d.%s%s\n",
                            item.getIndex(),
                            item.getDone() ? " [Done] " : " ",
                            item.getContent()));
                }
                builder.append(String.format("Total: %d items%s\n",
                        items.size(),
                        countOfDone > 0 ? String.format(", %d item done", countOfDone) : ""));
                result = builder.toString();
                break;
            default:
                break;
        }
        return result;
    }
}
