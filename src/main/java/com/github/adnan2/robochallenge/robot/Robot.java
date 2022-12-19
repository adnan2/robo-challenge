package com.github.adnan2.robochallenge.robot;

import com.github.adnan2.robochallenge.tabletop.TableTop;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class Robot {
    private String name;
    private RobotRotator rotator;
    private TableTop table;
    private Direction direction;
    private Integer x;
    private Integer y;

    public Robot(String name, Direction direction, RobotRotator rotator, TableTop table, Integer x, Integer y) {
        this.name = name;
        this.direction = direction;
        this.rotator = rotator;
        this.table = table;
        this.x = x;
        this.y = y;
    }

    public void move() {
        Integer newX = this.getX(), newY = this.getY();
        switch (this.getDirection()) {
            case EAST:
                newX = this.getX() + 1;
                break;
            case WEST:
                newX = this.getX() - 1;
                break;
            case NORTH:
                newY = this.getY() + 1;
                break;
            case SOUTH:
                newY = this.getY() - 1;
                break;
        }

        if (table.isPositionWithinLimits(newX, newY) && table.isPositionVacant(newX, newY)) {
            table.placeRobot(this, newX, newY);
            table.leaveSpot(this.x, this.y);
            setCurrentPosition(newX, newY);
        }

    }

    public void setCurrentPosition(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public void left() {
        direction = rotator.rotateLeft(direction);
    }

    public void right() {
        direction = rotator.rotateRight(direction);
    }

}
