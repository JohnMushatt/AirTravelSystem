import java.util.ArrayList;

public class Airport {

	private String airport_name;
	private ArrayList<Route> airport_routes = new ArrayList<>();
	private final double LONGITUDE;
	private final double LATITUDE;
	private String country;
	private String city;
	private String IATA_code;
	public Airport (String name, String country, String city, String code, double longitude, double latitude, String timezone) {
		
		this.airport_name = name;
		this.LONGITUDE= longitude;
		this.LATITUDE = latitude;
		this.country = country;
		this.city = city;
		this.IATA_code = code;
	}
	
	public void addRoute(Route route) {
		
		this.airport_routes.add(route);
	}
	
	private double getLongitude() {
		return this.LONGITUDE;
	}
	
	private double getLatitude() {
		return this.LATITUDE;
	}
	public String toString() {
		return "Airport name: " + this.airport_name +" Airport City: "+ this.city + "Airport Country:  " + this.country  + 
				" IATACode: " + this.IATA_code;
	}
	//MOVE TO ROUTE
	private double setRouteDistance(Route route) {
		
		double latDistance = Math.toRadians(route.getSourceAirport().getLatitude()
				- route.getDestinationAirport().getLatitude());
		double lngDistance = Math.toRadians(route.getSourceAirport().getLongitude()
				- route.getDestinationAirport().getLongitude());

		double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
				+ Math.cos(Math.toRadians(route.getSourceAirport().getLatitude())) * Math.cos(Math.toRadians(route.getDestinationAirport().getLatitude()))
			    * Math.sin(lngDistance / 2) * Math.sin(lngDistance / 2);

		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

		return Math.round(6371 * c);
	}

	
}
