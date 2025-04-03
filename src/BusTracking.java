public class BusTracking extends Reservation{
    @Override
    public void trackBus(String busNumber) {
        System.out.println("Bus " + busNumber + " is currently en route.");
    }
}
