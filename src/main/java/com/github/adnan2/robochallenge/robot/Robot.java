package com.github.adnan2.robochallenge.robot;

import com.github.adnan2.robochallenge.tabletop.TableTop;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@AllArgsConstructor
public class Robot {
    private Integer number;
    private String name;
    private RobotRotator rotator;
    private TableTop table;
    private Direction direction;
    private Integer x;
    private Integer y;

    public void move() {
//        log.info("before {} {}", x, y);
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
//        log.info("after {} {}", newX, newY);
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


    @Override
    public String toString() {
        String dir = "";
        if (direction == Direction.EAST) {
            dir = "→";
        } else if (direction == Direction.WEST) {
            dir = "←";
        } else if (direction == Direction.NORTH) {
            dir = "↑";
        } else {
            dir = "↓";
        }
        return String.format("%s %s %s", name, number, dir);
    }
}
