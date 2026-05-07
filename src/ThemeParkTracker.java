import java.util.ArrayList;

public class ThemeParkTracker {

    private ArrayList<Ride> rides;

    public ThemeParkTracker() {
        rides = new ArrayList<>();
    }

    public  void addRide(Ride ride) {
        //3. can't access rides.size()
        rides.add(ride);
    }

    public Ride getRide(int index) {
        if (index > rides.size()) {
            return null;
        }

        return rides.get(index);
    }

    public void removeClosedRides() {
        for (int i = 0; i < rides.size(); i++) {
            //4. == should be .equals()
            if (rides.get(i).getStatus().equals("closed")) {
                rides.remove(i);
            }
        }
    }

    public void printRide(String name) {
        for (Ride ride : rides) {
            //1. == should be.equals
            //5. ride should be ride .toString()
            if (ride.getName().equals(name)) {
                System.out.println(ride.toString());
            }
        }
    }

    public void removeRide(int index) {
        //6. index cant be equal to rides.size()
        if (index >= 0 && index < rides.size()) {
            rides.remove(index);
        }
    }

    public void printAllRides() {
        //7. -1 wouldn't get all rides
        for (int i = 0; i < rides.size(); i++) {
            System.out.println(rides.get(i));
        }
    }

    public void sortByWaitTime() {

        for (int i = 0; i < rides.size(); i++) {

            for (int j = i + 1; j < rides.size(); j++) {

                if (rides.get(i).getWaitTime() > rides.get(j).getWaitTime()) {

                    //8. swapped wait times instead of rides
                    Ride temp = rides.get(i);

                    rides.set(i, rides.get(j));

                    rides.set(j, temp);
                }
            }
        }
    }

    public String findRideStatus(String rideName) {
        for (Ride ride : rides) {
            //2. == should be .equals

            //9. Onle would return the status for the first one
            if (ride.getName().equals(rideName)) {

                return ride.getStatus();
            }

        }
            return "Ride not found";

    }
}