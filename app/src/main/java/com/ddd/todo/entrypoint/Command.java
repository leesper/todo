package com.ddd.todo.entrypoint;

public class Command {
    private String cmd;
    private String flag;
    private String arg;
    public Command(String[] args) {
        if (args[0].equals("add")) {
            cmd = args[0];
            flag = null;
            arg = args[1];
        } else if (args[0].equals("done")) {
            cmd = args[0];
            flag = null;
            arg = args[1];
        } else if (args[0].equals("list")) {
            cmd = args[0];
            if (args.length == 2) {
                flag = args[1];
                arg = null;
            } else {
                flag = null;
                arg = null;
            }

        }
    }

    public String cmd() {
        return cmd;
    }

    public Object flag() {
        return flag;
    }

    public String arg() {
        return arg;
    }
}
