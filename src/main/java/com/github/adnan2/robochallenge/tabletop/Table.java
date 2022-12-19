package com.github.adnan2.robochallenge.tabletop;

import com.github.adnan2.robochallenge.Robot;
import com.github.adnan2.robochallenge.commands.Direction;
import com.github.adnan2.robochallenge.commands.RobotRotator;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private Robot[][] map = new Robot[5][5];
    private List<Robot> robots = new ArrayList<>();
    private Robot active;

    public List<Robot> getRobots() {
        return robots;
    }

    public void placeRobot(int x, int y, Direction direction) {
        if (map[x][y] != null) {
            return;
        }
        Robot robot = new Robot("Robot" + this.robots.size() + 1, direction, new RobotRotator(), this);
        robots.add(robot);
        map[x][y] = robot;
        active = robot;
    }

    public void faceLeft() {
        if (active != null) {
            active.left();
        }
    }

    public void faceRight() {
        if (active != null) {
            active.right();
        }
    }

    public void move() {

    }
}
