package com.github.adnan2.robochallenge;

public class Main {
    public static void main(String[] args) {
        CommandParser cmd = new CommandParser(args);
        cmd.startListener(action -> {
            System.out.println("Received Action: "+ action);
        });
    }
}
