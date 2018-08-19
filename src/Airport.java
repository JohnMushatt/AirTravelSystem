import java.util.ArrayList;

public class Airport {

	private String airport_name;
	private ArrayList<Route> airport_routes = new ArrayList<>();
	private final double LONGITUDE;
	private final double LATITUDE;
	
	public Airport (String name, double longitude, double latitude) {
		
		this.airport_name = name;
		this.LONGITUDE= longitude;
		this.LATITUDE = latitude;
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
