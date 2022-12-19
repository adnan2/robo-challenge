package com.github.adnan2.robochallenge.commands;

import lombok.ToString;

@ToString
public class Report extends Command {
    public static final String SHORT_CMD = "rt";
    public static final String FULL_CMD = Report.class.getSimpleName().toLowerCase();
}
