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

    public void placeRobot(int x, int y, Direction direction) {
        Robot robot = new Robot("Robot " + (this.robots.size() + 1), direction, rotator, tableTop, x, y);

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
            tableTop.display();
        }
    }

    public void report() {
        if (activeRobot != null) {
            System.out.printf("Output: %d,%d,%s\n", this.activeRobot.getX(), this.activeRobot.getY(), this.activeRobot.getDirection());
        }
    }

    public void displayTable() {
        tableTop.display();
    }

    public void help() {
        String output = "" +
                "Robot Commands\n" +
                String.format("> %1$-20s", "place 1,2,north") + "\tTo Place a Robot at 1,2 facing North\n" +
                String.format("> %1$-20s", "left") + "\tTo change direction of Robot to the left side\n" +
                String.format("> %1$-20s", "right") + "\tTo change direction of Robot to the right side\n" +
                String.format("> %1$-20s", "move") + "\tTo move the robot in its current direction\n" +
                String.format("> %1$-20s", "report") + "\tTo display the position and direction of active robot\n" +
                String.format("> %1$-20s", "display") + "\tTo view tabletop grid with robots and their direction\n" +
                String.format("> %1$-20s", "help") + "\tTo display help\n" +
                "------------------------------------------------------\n" +
                "You can also use shortened commands for above mentioned commands.\n" +
                String.format("> %1$-20s", "p 1,2,north") + "\tTo Place a Robot at 1,2 facing North\n" +
                String.format("> %1$-20s", "l") + "\tTo change direction of Robot to the left side\n" +
                String.format("> %1$-20s", "r") + "\tTo change direction of Robot to the right side\n" +
                String.format("> %1$-20s", "m") + "\tTo move the robot in its current direction\n" +
                String.format("> %1$-20s", "rt") + "\tTo display the position and direction of active robot\n" +
                String.format("> %1$-20s", "d") + "\tTo view tabletop grid with robots and their direction\n" +
                String.format("> %1$-20s", "h") + "\tTo display help\n" +
                "------------------------------------------------------\n" +
                "Please enter a command below\n";

        System.out.println(output);
    }
}
