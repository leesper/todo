package com.ddd.todo.domain;

public class TodoItem {
    public TodoItem(String c) {
        index = -1;
        content = c;
        done = false;
    }

    public boolean getDone() {
        return done;
    }

    public void setDone(boolean d) {
        done = d;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int i) {
        index = i;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String c) {
        content = c;
    }

    private int index;
    private String content;
    private boolean done;
}
