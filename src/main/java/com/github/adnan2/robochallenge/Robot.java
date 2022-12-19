package com.github.adnan2.robochallenge;

import com.github.adnan2.robochallenge.commands.Direction;
import com.github.adnan2.robochallenge.commands.RobotRotator;
import com.github.adnan2.robochallenge.tabletop.Table;

public class Robot {
    private String name;
    private Direction direction;
    private RobotRotator rotator;
    private Table table;

    public Robot(String name, Direction direction, RobotRotator rotator, Table table) {
        this.name = name;
        this.direction = direction;
        this.rotator = rotator;
        this.table = table;
    }

    public String getName() {
        return name;
    }

    public Direction getDirection() {
        return this.direction;
    }

    public void move() {
        table.
    }

    public void left() {
        direction = rotator.rotateLeft(direction);
    }

    public void right() {
        direction = rotator.rotateRight(direction);
    }

    public String toString() {
        return "Robot " + name + " " + direction;
    }
}
