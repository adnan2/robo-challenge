package com.github.adnan2.robochallenge.tabletop;

import com.github.adnan2.robochallenge.config.TableConfig;
import com.github.adnan2.robochallenge.robot.Robot;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TableTop {
    TableConfig config;
    private Robot[][] map;

    @Autowired
    public TableTop(TableConfig config) {
        this.config = config;
        log.info("Table {} {}", config.getRows(), config.getColumns());
        map = new Robot[config.getRows()][config.getColumns()];
    }

    public boolean placeRobot(Robot r, Integer x, Integer y) {
        if (isPositionWithinLimits(x, y) && isPositionVacant(x, y)) {
            map[x][y] = r;
            return true;
        }
        return false;
    }

    public boolean isPositionVacant(Integer x, Integer y) {
        return map[x][y] == null;
    }

    public boolean isPositionWithinLimits(Integer x, Integer y) {
        return config.getRows() > x && x >= 0 && config.getColumns() > y && y >= 0;
    }

    public boolean leaveSpot(Integer x, Integer y) {
        if (isPositionWithinLimits(x, y)) {
            this.map[x][y] = null;
            return true;
        }
        return false;
    }


}
