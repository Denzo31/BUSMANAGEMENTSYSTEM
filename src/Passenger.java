public class Passenger {
    private int id;
    private String name;
    private int age;
    private int ticketNumber;
    private int seatNumber;
    private String destination;
    private double distance;
    private String plateNumber;

    // constructor
    public Passenger(int id, String name, int age, int ticketNumber, int seatNumber, String destination, double distance, String plateNumber) {
        if (age < 6) {
            throw new IllegalArgumentException("Passenger must be at least 6 years old.");
        }
        this.id = id;
        this.name = name;
        this.age = age;
        this.ticketNumber = ticketNumber;
        this.seatNumber = seatNumber;
        this.destination = destination;
        this.distance = distance;
        this.plateNumber = plateNumber;
    }

    // Getters to access private attributes
    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public int getTicketNumber() { return ticketNumber; }
    public int getSeatNumber() { return seatNumber; }
    public String getDestination() { return destination; }
    public double getDistance() { return distance; }
    public String getPlateNumber() { return plateNumber; }
}