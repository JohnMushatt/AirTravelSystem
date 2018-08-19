
public class Route {
	
	private double distance;
	private double flight_time;
	private String route_name;
	private int open_seats;
	private int total_seats;
	private Airport source_airport;
	private Airport destination_airport;
	
	public Route (Airport source, Airport destination, String name, int seats, double distance, double flight_time) {
		this.source_airport= source;
		this.destination_airport= destination;
		this.route_name = name;
		this.total_seats = seats;
		this.distance = distance;
		this.flight_time = flight_time;
		this.open_seats= this.total_seats;
	}
	
	private boolean enoughSeats()
	{
		if(open_seats<=total_seats) {
			return true;
		}
		else
			return false;
	}
	
	public boolean addPassenger() {
		if(enoughSeats()) { 
			open_seats--;
			return true;
		}
		else
			return false;
	}
	public Airport getSourceAirport() {
		return this.source_airport;
	}
	public Airport getDestinationAirport() {
		return this.destination_airport;
	}
}
