package com.github.adnan2.robochallenge.controller;

import com.github.adnan2.robochallenge.robot.Robot;
import com.github.adnan2.robochallenge.robot.Direction;
import com.github.adnan2.robochallenge.robot.RobotRotator;
import com.github.adnan2.robochallenge.tabletop.TableTop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RoboController {
    private List<Robot> robots = new ArrayList<>();
    private Robot activeRobot;
    private TableTop tableTop;
    private RobotRotator rotator;

    @Autowired
    public RoboController(RobotRotator rotator, TableTop tableTop) {
        this.rotator = rotator;
        this.tableTop = tableTop;
    }

    public List<Robot> getRobots() {
        return robots;
    }

    public void placeRobot(int x, int y, Direction direction) {
        Robot robot = new Robot("Robot" + this.robots.size() + 1, direction, rotator, tableTop, x, y);

        if (tableTop.placeRobot(robot, x, y)) {
            robots.add(robot);
            activeRobot = robot;
        }
    }

    public void faceLeft() {
        if (activeRobot != null) {
            activeRobot.left();
        }
    }

    public void faceRight() {
        if (activeRobot != null) {
            activeRobot.right();
        }
    }

    public void move() {
        if (activeRobot != null) {
            activeRobot.move();
        }
    }

    public void report() {
        if (activeRobot != null) {
            System.out.printf("Output: %d,%d,%s", this.activeRobot.getX(), this.activeRobot.getY(), this.activeRobot.getDirection());
        }
    }
}
