import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ThemeParkTrackerTest {

    @org.junit.jupiter.api.Test
    void addRide() {
        ThemeParkTracker rides = new ThemeParkTracker();
        Ride ride = new Ride("James", 7, 1, "open");
        rides.addRide(ride);
        assertEquals(rides.getRide(0), ride);
    }

    @org.junit.jupiter.api.Test
    void getRide() {
        ThemeParkTracker rides = new ThemeParkTracker();
        Ride ride = new Ride("James", 7, 1, "open");
        rides.addRide(ride);
        assertEquals(rides.getRide(0), ride);
    }

    @org.junit.jupiter.api.Test
    void removeClosedRides() {
        ThemeParkTracker rides = new ThemeParkTracker();
        Ride ride = new Ride("James", 7, 1, "closed");
        rides.addRide(ride);
        Ride ride2 = new Ride("Jamses", 500, 5555, "open");
        rides.addRide(ride2);
        rides.removeClosedRides();
        assertEquals(rides.getRide(0), ride2);
    }

    @org.junit.jupiter.api.Test
    void removeRide() {
        ThemeParkTracker rides = new ThemeParkTracker();
        Ride ride = new Ride("James", 7, 1, "closed");
        rides.addRide(ride);
        Ride ride2 = new Ride("Jamses", 500, 5555, "open");
        rides.addRide(ride2);
        rides.removeRide(0);
        assertEquals(rides.getRide(0), ride2);
    }

    @org.junit.jupiter.api.Test
    void sortByWaitTime() {
        ThemeParkTracker rides = new ThemeParkTracker();
        Ride ride = new Ride("James", 70000, 1, "closed");
        rides.addRide(ride);
        Ride ride2 = new Ride("Jamses", 500, 5555, "open");
        rides.addRide(ride2);
        rides.sortByWaitTime();
        assertEquals(rides.getRide(0), ride2);
    }

    @org.junit.jupiter.api.Test
    void findRideStatus() {
        ThemeParkTracker rides = new ThemeParkTracker();
        Ride ride = new Ride("James", 7, 1, "closed");
        rides.addRide(ride);
        Ride ride2 = new Ride("Jamses", 500, 5555, "open");
        rides.addRide(ride2);
        assertEquals("closed", rides.findRideStatus(ride.getName()));
        assertEquals("open", rides.findRideStatus(ride2.getName()));
    }
}