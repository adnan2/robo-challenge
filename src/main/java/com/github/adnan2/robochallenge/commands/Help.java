package com.github.adnan2.robochallenge.commands;

import lombok.ToString;

@ToString
public class Help extends Command {
    public static final String SHORT_CMD = "h";
    public static final String FULL_CMD = Help.class.getSimpleName().toLowerCase();
}
