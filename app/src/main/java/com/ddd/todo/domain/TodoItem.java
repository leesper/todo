package com.ddd.todo.domain;

public class TodoItem {
    public TodoItem(int i, String c) {
        index = i;
        content = c;
        done = false;
    }

    public boolean getDone() {
        return done;
    }

    public void setDone(boolean d) {
        done = d;
    }

    private int index;
    private String content;
    private boolean done;
}
