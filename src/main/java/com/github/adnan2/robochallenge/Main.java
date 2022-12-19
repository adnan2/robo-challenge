package com.github.adnan2.robochallenge;

import com.github.adnan2.robochallenge.commands.*;
import com.github.adnan2.robochallenge.commands.parser.CommandParser;
import com.github.adnan2.robochallenge.config.TableConfig;
import com.github.adnan2.robochallenge.controller.RoboController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(TableConfig.class)
@Slf4j
public class Main implements CommandLineRunner {

    @Autowired
    private RoboController roboController;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) {
        CommandParser cmd = new CommandParser(args);
        cmd.startListener(action -> {
            System.out.println("Received Action: " + action);
            if (action instanceof Place) {
                Place place = (Place) action;
                roboController.placeRobot(place.getX(), place.getY(), place.getDirection());
            } else if (action instanceof Left) {
                roboController.faceLeft();
            } else if (action instanceof Right) {
                roboController.faceRight();
            } else if (action instanceof Report) {
                roboController.report();
            } else if (action instanceof Move) {
                roboController.move();
            }
        });
    }
}
