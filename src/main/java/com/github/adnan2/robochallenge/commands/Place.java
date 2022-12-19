package com.github.adnan2.robochallenge.commands;

import com.github.adnan2.robochallenge.robot.Direction;
import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class Place extends Command {

    private Integer x;
    private Integer y;
    private Direction direction;

    public Place(Integer x, Integer y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

}
