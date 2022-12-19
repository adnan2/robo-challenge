package com.github.adnan2.robochallenge.commands;

import lombok.ToString;

@ToString
public class Move extends Command {
    public static final String SHORT_CMD = "m";
    public static final String FULL_CMD = Move.class.getSimpleName().toLowerCase();

}
