package com.rabestro.codeforces;

import java.util.*;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        final var shell = new Shell();
        final var scanner = new Scanner(System.in);
        final var n = Integer.parseInt(scanner.nextLine());

        Stream.generate(scanner::nextLine).limit(n).forEach(shell::execute);
    }
}

class Shell {
    private final Deque<String> directories = new LinkedList<>();

    public void execute(String command) {
        if (command.startsWith("pwd")) {
            pwd();
        } else {
            cd(command.split(" ")[1]);
        }
    }

    public void pwd() {
        System.out.println("/"
                + String.join("/", directories)
                + (directories.isEmpty() ? "" : "/"));
    }

    public void cd(String path) {
        Arrays.stream(path.split("/")).forEach(dir -> {
            if ("".equals(dir)) {
                directories.clear();
            } else if ("..".equals(dir)) {
                directories.removeLast();
            } else {
                directories.add(dir);
            }
        });
    }
}