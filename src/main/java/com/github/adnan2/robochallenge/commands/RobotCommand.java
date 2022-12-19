package com.github.adnan2.robochallenge.commands;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@ToString
@Data
@AllArgsConstructor
public class RobotCommand extends Command {
    public static final String SHORT_CMD = "rb";
    public static final String FULL_CMD = "robot";
    private Integer robotNumber;
}
