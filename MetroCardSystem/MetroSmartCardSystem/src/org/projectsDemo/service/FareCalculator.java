package org.projectsDemo.service;

import org.projectsDemo.model.Station;
import org.projectsDemo.strategy.FareStrategy;
import org.projectsDemo.strategy.FareStrategyFactory;

import java.time.LocalDateTime;

public class FareCalculator {

    public double getFare(Station source, Station destination, LocalDateTime localDateTime) {
        FareStrategy fareStrategy = FareStrategyFactory.getFareStrategy(localDateTime);
        int distance = source.distance(destination);

        double fare = distance * fareStrategy.getFarePerStation();

        return fare;
    }
}
