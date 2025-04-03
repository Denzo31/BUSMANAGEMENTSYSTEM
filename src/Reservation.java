import java.util.*;

public class Reservation implements PassengerManagement{
    private static final int MAX_SEATS = 50;
    private Map<String, Set<Integer>> busSeats = new HashMap<>();

    @Override
    public boolean bookTicket(String passengerId, int seatNumber, String destination, double distance) {
        if (!busSeats.containsKey(destination)) {
            busSeats.put(destination, new HashSet<>());
        }
        if (busSeats.get(destination).size() >= MAX_SEATS) {
            System.out.println("Bus is fully booked for " + destination + "!");
            return false;
        }
        if (busSeats.get(destination).contains(seatNumber)) {
            System.out.println("Seat " + seatNumber + " is already taken!");
            return false;
        }
        busSeats.get(destination).add(seatNumber);
        System.out.println("Booking successful for Passenger ID: " + passengerId);
        return true;
    }

    @Override
    public double calculateFare(double distance, boolean isDiscounted) {
        double fare = distance * 200000;
        return isDiscounted ? fare * 0.8 : fare;
    }

    @Override
    public void trackBus(String busNumber) {
        System.out.println("Tracking bus " + busNumber + "...");
    }
}
