package com.github.adnan2.robochallenge.robot;

import org.springframework.stereotype.Component;

@Component
public class RobotRotator {
    public Direction rotateLeft(Direction current) {
        //      N
        //  W       E
        //      S
        switch (current) {
            case NORTH:
                return Direction.WEST;
            case WEST:
                return Direction.SOUTH;
            case SOUTH:
                return Direction.EAST;
            case EAST:
                return Direction.NORTH;
            default:
                return current;
        }

    }
    public Direction rotateRight(Direction current) {
        //      N
        //  W       E
        //      S
        switch (current) {
            case NORTH:
                return Direction.EAST;
            case EAST:
                return Direction.SOUTH;
            case SOUTH:
                return Direction.WEST;
            case WEST:
                return Direction.NORTH;
            default:
                return current;
        }

    }
}
