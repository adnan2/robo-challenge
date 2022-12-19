package com.github.adnan2.robochallenge.commands;


public abstract class Command {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
