import java.util.Scanner;
import javax.swing.*;
import java.util.Arrays;

public class FlightTest {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter the number of flights: ");
        int numberOfFlights = scan.nextInt();
        scan.nextLine();  // Consume the newline character left by nextInt()

        Flight[] flights = new Flight[numberOfFlights];

        for (int i = 0; i < numberOfFlights; i++) {
            System.out.println("\nEnter details for flight #" + (i + 1) + "!");
            System.out.println("Airline: ");
            String airline = scan.nextLine();
            System.out.println("Flight Number: ");
            String flightNum = scan.nextLine();
            System.out.println("Flight Origin: ");
            String flightOrigin = scan.nextLine();
            System.out.println("Destination: ");
            String destination = scan.nextLine();
            System.out.println("Airfare: ");
            double airFare = scan.nextDouble();
            scan.nextLine();  // Consume the newline character left by nextDouble()
            System.out.println("Departure Time: ");
            String departureTime = scan.nextLine();
            System.out.println("Arrival Time: ");
            String arrivalTime = scan.nextLine();
            
         // Create Flight object and add it to an array
            flights[i] = new Flight(airline, flightNum, flightOrigin, destination, airFare, departureTime, arrivalTime, "");
            
            // After creating the Flight object, calculate total travel time and store it in a variable
            Double flightDur = flights[i].calculateTotalTravelTime();
    
            // Set the flight duration using the setter method
            flights[i].setFlightDuration(flightDur);
           
        } 
        
        // print out pre-sorted information
        System.out.println("Before Sorting:");
        for (Flight flight : flights) {
            System.out.println(flight);
        }
        
        // Sort flights based on flight number
        Arrays.sort(flights, (flight1, flight2) -> flight1.getFlightNumber().compareTo(flight2.getFlightNumber()));
        
        // print out sorted information
        System.out.println("After Sorting by Flight Number:");
        for (Flight flight : flights) {
            System.out.println(flight);
        }
        
        // create form1 instance with flights arrays
        SwingUtilities.invokeLater(() -> new Form1(flights));
    }
}
