package com.github.adnan2.robochallenge.tabletop;

import com.github.adnan2.robochallenge.config.TableConfig;
import com.github.adnan2.robochallenge.robot.Robot;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Slf4j
@Component
public class TableTop {
    private TableConfig config;
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


    public void display() {
        int maxLen = 15;
        int padding = 4;

        System.out.printf("%1$-" + padding + "s", "");
        printForEachColumn((t) -> String.format(" %1$-" + maxLen + "s", t));
        for (int r = config.getRows() - 1; r >= 0; r--) {
            System.out.printf("%1$-" + padding + "s", "");
            printForEachColumn((t) -> String.format("+%1$-" + maxLen + "s", "").replace(' ', '-'));
            final int currentRow = r;
            System.out.printf("%1$-" + padding + "s", r);
            printForEachColumn((x) -> {
                Robot robot = map[x][currentRow];
                return String.format(" %1$-" + maxLen + "s", robot == null ? "" : robot.toString());
            });
        }
        System.out.printf("%1$-" + padding + "s", "");
        printForEachColumn((t) -> String.format("+%1$-" + maxLen + "s", "").replace(' ', '-'));
    }

    private void printForEachColumn(Function<Integer, String> valueFunc) {
        for (int c = 0; c < config.getColumns(); c++) {
            System.out.printf(valueFunc.apply(c));
        }
        System.out.println();
    }
}
