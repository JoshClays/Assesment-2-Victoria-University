import java.util.Locale;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Flight {
	// declare instance variables 
	private String airline_name;
	private String flight_number;
	private String flight_origin;
	private String destination_cities;
	private double airFare;
	private String departureTime;
	private String arrivalTime;
	private double totalMinutes;
	private String flightDuration;
	private double flightDur;
	private double totalHours;
	// constructor 
	public Flight (String airline_name, String flight_number, String flight_origin, String destination_cities, double airfare, String departureTime, String arrivalTime, String flightDuration) {
		this.airline_name = airline_name;
		this.flight_number = flight_number;
		this.flight_origin = flight_origin;
		this.destination_cities = destination_cities;
		this.airFare = airfare;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.flightDuration = flightDuration;
	} // end of constructor
	
	// Calculate and return total travel time in hours
	public double calculateTotalTravelTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalDateTime departureDateTime = LocalDateTime.of(LocalDate.now(), LocalTime.parse(this.departureTime, formatter));
        LocalDateTime arrivalDateTime = LocalDateTime.of(LocalDate.now(), LocalTime.parse(this.arrivalTime, formatter));

        // Check if arrival is before departure, indicating flight spans multiple days
        if (arrivalDateTime.isBefore(departureDateTime)) {
            // Add one day to arrivalDateTime if it's before departureDateTime (flight spans next day)
            arrivalDateTime = arrivalDateTime.plusDays(1);
        } else if (arrivalDateTime.isEqual(departureDateTime)) { // flight that has the same departure time and arrival time on the next day (24 Hours flight)
        	arrivalDateTime = arrivalDateTime.plusMinutes(1440);
        }

        // Calculate total travel time in minutes
        this.totalMinutes = ChronoUnit.MINUTES.between(departureDateTime, arrivalDateTime);

        
        // Convert total minutes to hours with two decimal places
        double totalHours = totalMinutes / 60.0;

        // Format totalHours with two decimal places
        String formattedTime = String.format(Locale.US, "%.2f", totalHours);
        
        // Store the formatted time in flightDuration variable
        this.flightDuration = formattedTime;
        return Double.parseDouble(formattedTime);
        
    }
	
	
	// toString() method
	
	public String toString() {
		return "Flight[airlineName= " + "'" + airline_name + "'" +
				", flightnumber = " + "'" + flight_number + "'" +
				", originCity= " + "'"	+ flight_origin + "'" +
				", destinationCity = " + "'" + destination_cities + "'" + 
				", airFare= " + "'"	+ airFare + "'"	+ 
				", departureTime = " + "'" + departureTime + "'" +
				", arrivalTime= " + "'" + arrivalTime + "'" +
				", flightDuration= " + "'" + flightDuration + " " + "Hours" + "']";
	} // end of toString() method
	
	// getter and setter method for all instance variables
	
	// getter method for flight number
	public String getFlightNumber () {
		
		return flight_number;
	}
	
	// getter method for airline name
	public String getAirlineName () {
		return airline_name;
		
	}
	
	// getter method for flight origin 
	public String getFlightOrigin () {
		
		return flight_origin;
		
	}
	
	// getter method for destination cities
	public String getDestinationCities ()	{
		
		return destination_cities;
	}
	
	// getter method for Airfare
	public Double getAirfare ()	{
			
			return airFare ;
		}
		
	// getter method for departure time
	public String getDepartureTime ()	{
			
			return departureTime;
		}
	// getter method for arrival time
	public String getArrivalTime ()	{
			
			return arrivalTime;
		}

	// setter method for flight duration
	 public void setFlightDuration(double flightDur ) {
	        this.flightDur = flightDur;
	    }
		

	public static void main(String[] args) {
		

	}

}
