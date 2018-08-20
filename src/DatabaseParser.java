import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
public class DatabaseParser {

	private Scanner csv_scanner;
	private File csv_file;
	private String csv_file_name;
	private final String DELIMTER = ",";
	private final String ENCODING = "utf-8";
	// Airline ID, Name, Alias, IATA, ICAO, Callsign, Country, Active
	
	public DatabaseParser (String csv_file_name) {
		
		this.csv_file_name = csv_file_name;
		try	{
			this.csv_file= new File(this.csv_file_name);
			System.out.println("File name: " + this.csv_file_name +"\n");
			this.csv_scanner = new Scanner(this.csv_file, this.ENCODING);
			//this.csv_scanner.useDelimiter(DELIMTER);

		}
		catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
	}
	private String getAirportName(String line) {
		
		line= line.substring(line.indexOf(DELIMTER) + 1);
		return line.substring(0, line.indexOf(DELIMTER));
	}
	
	private String getAirportCountry(String line) { 
		
		return line;
	}
	
	private String getAirportCity(String line) { 
		
		return line;
	}
	
	private String getAirportIATA(String line) { 
		
		return line;
	}
	
	private double getAirportLatitude(String line) {
		
		return 0;
	}
	
	private double getAirportLongitude(String line) { 
		
		return 0;
	}
	
	private String getAirportTimezone(String line) {
		
		return line;
	}
	
	private boolean isAirport(String line) {
		
		return false;
	}
	//number,airport,country
	public ArrayList<Airport> parseAirports() {
		ArrayList<Airport> airports = new ArrayList<>();
		boolean finished_current_line = false;
		
		while (this.csv_scanner.hasNextLine()) {
			
			String current_line = this.csv_scanner.nextLine();
			
			if(isAirport(current_line)) {
				
				airports.add(new Airport(getAirportName(current_line), getAirportCountry(current_line),
						getAirportCity(current_line), getAirportIATA(current_line), getAirportLatitude(current_line),
						getAirportLongitude(current_line), getAirportTimezone(current_line)));
			}
		}
		
		return airports;
	}
	
	
	public static void main(String[] args) {
		DatabaseParser parser = new DatabaseParser("C:\\Users\\johnm\\Documents\\GitHub\\AirTravelSystem\\ATS\\airports.dat.txt");
		
		ArrayList<Airport> airport = parser.parseAirports();
	}
}
