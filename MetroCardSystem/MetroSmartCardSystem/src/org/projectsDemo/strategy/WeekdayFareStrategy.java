package org.projectsDemo.strategy;

public class WeekdayFareStrategy implements FareStrategy {

    @Override
    public double getFarePerStation() {
        return 7;
    }
}
