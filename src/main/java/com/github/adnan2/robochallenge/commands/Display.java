package com.github.adnan2.robochallenge.commands;

import lombok.ToString;

@ToString
public class Display extends Command {
    public static final String SHORT_CMD = "d";
    public static final String FULL_CMD = Display.class.getSimpleName().toLowerCase();
}
