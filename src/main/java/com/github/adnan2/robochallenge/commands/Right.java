package com.github.adnan2.robochallenge.commands;

import lombok.ToString;

@ToString
public class Right extends Command {
    public static final String SHORT_CMD = "r";
    public static final String FULL_CMD = Right.class.getSimpleName().toLowerCase();
}
