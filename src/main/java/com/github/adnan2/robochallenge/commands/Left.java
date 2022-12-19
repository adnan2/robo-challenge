package com.github.adnan2.robochallenge.commands;

import lombok.ToString;

@ToString
public class Left extends Command {
    public static final String SHORT_CMD = "l";
    public static final String FULL_CMD = Left.class.getSimpleName().toLowerCase();
}
