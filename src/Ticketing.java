public class Ticketing extends Reservation{
    public double generateTicket(Passenger passenger) {
        boolean isDiscounted = passenger.getAge() >= 60;
        return calculateFare(passenger.getDistance(), isDiscounted);
    }
}
