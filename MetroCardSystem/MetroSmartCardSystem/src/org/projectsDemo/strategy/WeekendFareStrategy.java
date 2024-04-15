package org.projectsDemo.strategy;

public class WeekendFareStrategy implements FareStrategy {

    @Override
    public double getFarePerStation() {
        return 5.5;
    }
}
