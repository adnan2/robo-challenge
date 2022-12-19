package com.github.adnan2.robochallenge.controller;

import com.github.adnan2.robochallenge.commands.*;
import com.github.adnan2.robochallenge.robot.Direction;
import com.github.adnan2.robochallenge.robot.Robot;
import com.github.adnan2.robochallenge.robot.RobotRotator;
import com.github.adnan2.robochallenge.tabletop.TableTop;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
public class RoboController {
    private Map<Integer, Robot> robots = new HashMap<>();
    private Robot activeRobot;
    private TableTop tableTop;
    private RobotRotator rotator;

    @Autowired
    public RoboController(RobotRotator rotator, TableTop tableTop) {
        this.rotator = rotator;
        this.tableTop = tableTop;
    }

    public void placeRobot(int x, int y, Direction direction) {
        Robot robot = new Robot((this.robots.size() + 1), "Robot ", rotator, tableTop, direction, x, y);

        if (tableTop.placeRobot(robot, x, y)) {
            robots.put(robot.getNumber(), robot);
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
            System.out.printf("Output: %d,%d,%s\n", this.activeRobot.getX(), this.activeRobot.getY(), this.activeRobot.getDirection());
        }
    }

    public void displayTable() {
        tableTop.display();
    }

    public void activateRobot(Integer robotNumber) {
        Robot robot = this.robots.get(robotNumber);
        if (robot == null) {
            log.error("Could not find a robot on tabletop by number: {}", robotNumber);
        } else {
            this.activeRobot = robot;
            log.info("Activated Robot: {}", this.activeRobot);
        }
    }

    public void help() {
        String output = "" +
                "Robot Commands\n" +
                String.format("> %1$-20s", PlaceCommand.FULL_CMD + " 1,2,north") + "\tTo Place a Robot at 1,2 facing North\n" +
                String.format("> %1$-20s", LeftCommand.FULL_CMD) + "\tTo change direction of Robot to the left side\n" +
                String.format("> %1$-20s", RightCommand.FULL_CMD) + "\tTo change direction of Robot to the right side\n" +
                String.format("> %1$-20s", MoveCommand.FULL_CMD) + "\tTo move the robot in its current direction\n" +
                String.format("> %1$-20s", ReportCommand.FULL_CMD) + "\tTo display the position and direction of active robot\n" +
                String.format("> %1$-20s", DisplayCommand.FULL_CMD) + "\tTo view tabletop grid with robots and their direction\n" +
                String.format("> %1$-20s", RobotCommand.FULL_CMD + " 2") + "\tTo activate a specific robot by its number\n" +
                String.format("> %1$-20s", HelpCommand.FULL_CMD) + "\tTo display help\n" +
                "------------------------------------------------------\n" +
                "You can also use shortened commands for above mentioned commands.\n" +
                String.format("> %1$-20s", PlaceCommand.SHORT_CMD + " 1,2,north") + "\tTo Place a Robot at 1,2 facing North\n" +
                String.format("> %1$-20s", LeftCommand.SHORT_CMD) + "\tTo change direction of Robot to the left side\n" +
                String.format("> %1$-20s", RightCommand.SHORT_CMD) + "\tTo change direction of Robot to the right side\n" +
                String.format("> %1$-20s", MoveCommand.SHORT_CMD) + "\tTo move the robot in its current direction\n" +
                String.format("> %1$-20s", ReportCommand.SHORT_CMD) + "\tTo display the position and direction of active robot\n" +
                String.format("> %1$-20s", DisplayCommand.SHORT_CMD) + "\tTo view tabletop grid with robots and their direction\n" +
                String.format("> %1$-20s", RobotCommand.SHORT_CMD + " 2") + "\tTo activate a specific robot by its number\n" +
                String.format("> %1$-20s", HelpCommand.SHORT_CMD) + "\tTo display help\n" +
                "------------------------------------------------------\n" +
                "Please enter a command below\n";

        System.out.println(output);
    }
}
