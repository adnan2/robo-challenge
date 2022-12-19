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
                if (command.toLowerCase().startsWith("place")) {
                    try {
                        String[] split = command.split(" ");
                        if (split.length > 1) {
                            String value = split[1];
                            String[] split2 = value.split(",");
                            if (split2.length > 2) {
                                Integer x = Integer.parseInt(split2[0]);
                                Integer y = Integer.parseInt(split2[1]);
                                String direction = split2[2];

                                action.accept(new Place(x, y, Direction.valueOf(direction.toUpperCase())));
                            }
                        }
                    } catch (IllegalArgumentException e1) {
                        log.error(e1.getMessage());
                    }
                } else {
                    String trim = command.trim();
                    if (trim.equalsIgnoreCase(Left.class.getSimpleName())) {
                        action.accept(new Left());
                    } else if (trim.equalsIgnoreCase(Right.class.getSimpleName())) {
                        action.accept(new Right());
                    } else if (trim.equalsIgnoreCase(Move.class.getSimpleName())) {
                        action.accept(new Move());
                    } else if (trim.equalsIgnoreCase(Report.class.getSimpleName())) {
                        action.accept(new Report());
                    }
                }
            } catch (IOException e) {
                log.error(e.getMessage());
            }

        } while (true);
    }
}
