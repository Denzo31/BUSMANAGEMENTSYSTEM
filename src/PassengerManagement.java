public interface PassengerManagement {
    boolean bookTicket(String passengerId, int seatNumber, String destination, double distance);
    double calculateFare(double distance, boolean isDiscounted);
    void trackBus(String busNumber);
}