import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // Create system objects
        Reservation reservation = new Reservation();
        Ticketing ticketing = new Ticketing();
        BusTracking busTracking = new BusTracking();

        // Create Scanner for input
        Scanner scanner = new Scanner(System.in);

        // Ask user for passenger details with input validation

        int passengerId;
        while (true) {
            System.out.println("Enter Passenger ID: ");
            if (scanner.hasNextInt()) {
                passengerId = scanner.nextInt();
                break; // Break if the input is a valid integer
            } else {
                System.out.println("Invalid input. Please enter a valid numeric Passenger ID.");
                scanner.next(); // Consume invalid input
            }
        }

        scanner.nextLine();  // Consume the newline character

        String name;
        while (true) {
            System.out.println("Enter Passenger Name: ");
            name = scanner.nextLine();
            if (name.matches("[a-zA-Z ]+")) {  // Check if name contains only letters and spaces
                break;
            } else {
                System.out.println("Invalid input. Name should only contain letters and spaces.");
            }
        }

        int age;
        while (true) {
            System.out.println("Enter Passenger Age: ");
            if (scanner.hasNextInt()) {
                age = scanner.nextInt();
                if (age >= 6) {
                    break; // Age must be 6 or more
                } else {
                    System.out.println("Passenger must be at least 6 years old.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid numeric age.");
                scanner.next(); // Consume invalid input
            }
        }

        int ticketNumber;
        while (true) {
            System.out.println("Enter Ticket Number: ");
            if (scanner.hasNextInt()) {
                ticketNumber = scanner.nextInt();
                break; // Break if the input is a valid integer
            } else {
                System.out.println("Invalid input. Please enter a valid numeric Ticket Number.");
                scanner.next(); // Consume invalid input
            }
        }

        int seatNumber;
        while (true) {
            System.out.println("Enter Seat Number: ");
            if (scanner.hasNextInt()) {
                seatNumber = scanner.nextInt();
                break; // Break if the input is a valid integer
            } else {
                System.out.println("Invalid input. Please enter a valid numeric Seat Number.");
                scanner.next(); // Consume invalid input
            }
        }

        scanner.nextLine();  // Consume the newline character

        String destination;
        System.out.println("Enter Destination: ");
        destination = scanner.nextLine();

        double distance;
        while (true) {
            System.out.println("Enter Distance (in kilometers): ");
            if (scanner.hasNextDouble()) {
                distance = scanner.nextDouble();
                if (distance > 0) {
                    break; // Distance must be greater than 0
                } else {
                    System.out.println("Distance must be a positive number.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid numeric Distance.");
                scanner.next(); // Consume invalid input
            }
        }

        scanner.nextLine();  // Consume the newline character

        String plateNumber;
        System.out.println("Enter Bus Plate Number: ");
        plateNumber = scanner.nextLine();

        // Create a Passenger object
        Passenger passenger = new Passenger(passengerId, name, age, ticketNumber, seatNumber, destination, distance, plateNumber);

        // Try to book a ticket
        boolean booked = reservation.bookTicket(String.valueOf(passengerId), seatNumber, destination, distance);
        if (booked) {
            double fare = ticketing.generateTicket(passenger);
            System.out.println("Passenger " + passenger.getName() + " should pay: " + fare);
        }

        // Track bus location
        busTracking.trackBus(plateNumber);

        // Close scanner to prevent resource leaks
        scanner.close();
    }
}