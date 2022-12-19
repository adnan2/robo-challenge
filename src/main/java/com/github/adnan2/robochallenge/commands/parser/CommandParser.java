package com.github.adnan2.robochallenge.commands.parser;

import com.github.adnan2.robochallenge.commands.*;
import com.github.adnan2.robochallenge.robot.Direction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;

@Slf4j
@Component
public class CommandParser {
    String[] args = {};

    public CommandParser(String[] args) {
        if (args != null) {
            this.args = args;
        }
    }


    public void startListener(Consumer<Command> action) {
        do {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            try {
                String command = br.readLine();
                String trim = command.trim();
                if (trim.toLowerCase().startsWith(Place.FULL_CMD.toLowerCase()) || trim.toLowerCase().startsWith(Place.SHORT_CMD.toLowerCase())) {
                    try {
                        //ignore spaces after the first expected space
                        String secondPart = trim.substring(trim.indexOf(" ") + 1).replace(" ", "");
                        String[] split = secondPart.split(",");
                        if (split.length == 3) {
                            Integer x = Integer.parseInt(split[0]);
                            Integer y = Integer.parseInt(split[1]);
                            String direction = split[2];
                            action.accept(new Place(x, y, Direction.valueOf(direction.toUpperCase())));
                        } else {
                            log.error("Invalid command: {}, ", command);
                        }

                    } catch (IllegalArgumentException e1) {
                        log.error(e1.getMessage());
                    }
                } else if (trim.equalsIgnoreCase(Left.FULL_CMD) || trim.equalsIgnoreCase(Left.SHORT_CMD)) {
                    action.accept(new Left());
                } else if (trim.equalsIgnoreCase(Right.FULL_CMD) || trim.equalsIgnoreCase(Right.SHORT_CMD)) {
                    action.accept(new Right());
                } else if (trim.equalsIgnoreCase(Move.FULL_CMD) || trim.equalsIgnoreCase(Move.SHORT_CMD)) {
                    action.accept(new Move());
                } else if (trim.equalsIgnoreCase(Report.FULL_CMD) || trim.equalsIgnoreCase(Report.SHORT_CMD)) {
                    action.accept(new Report());
                } else if (trim.equalsIgnoreCase(Display.FULL_CMD) || trim.equalsIgnoreCase(Display.SHORT_CMD)) {
                    action.accept(new Display());
                } else if (trim.equalsIgnoreCase(Help.FULL_CMD) || trim.equalsIgnoreCase(Help.SHORT_CMD)) {
                    action.accept(new Help());
                } else if (trim.toLowerCase().startsWith(RobotCommand.FULL_CMD.toLowerCase()) || trim.toLowerCase().startsWith(RobotCommand.SHORT_CMD.toLowerCase())) {
                    String[] split = trim.split(" ");
                    try {
                        if (split.length > 1) {
                            Integer id = Integer.parseInt(split[1]);
                            action.accept(new RobotCommand(id));
                        }
                    } catch (IllegalArgumentException e) {
                        log.error(e.getMessage());
                    }
                }

            } catch (IOException e) {
                log.error(e.getMessage());
            }

        } while (true);
    }
}
