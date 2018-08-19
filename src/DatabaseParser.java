import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
public class DatabaseParser {

	private Scanner csv_scanner;
	private File csv_file;
	private String csv_file_name;
	private final String DELIMTER = ",";
	private final String ENCODING = "UTF-8";
	// Airline ID, Name, Alias, IATA, ICAO, Callsign, Country, Active
	
	public DatabaseParser (String csv_file_name) {
		
		this.csv_file_name = csv_file_name;
		try	{
			this.csv_file= new File(this.csv_file_name);
			System.out.println("File name: " + this.csv_file_name +"\n");
			this.csv_scanner = new Scanner(this.csv_file, this.ENCODING);
			this.csv_scanner.useDelimiter(DELIMTER);

		}
		catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
	}
	private String getAirportNames(String line) {
		String name;
		Scanner scanner = new Scanner(line);
		name = scanner.next();
		System.out.println("This is line " + line);
		//name = name.substring(1);
		//name = name.substring(0, name.indexOf(DELIMTER) +1);
		//name = name.substring(name.indexOf("\"") + 1, name.indexOf("\""));
		return name;
	}
	
	//number,airport,country
	public ArrayList<Airport> parseAirports() {
		ArrayList<Airport> airports = new ArrayList<>();
		int count = 0;
		while(this.csv_scanner.hasNextLine()) {
			String current_line = this.csv_scanner.nextLine();
			current_line = current_line.substring(current_line.indexOf(DELIMTER) + 1);
			
			System.out.println(getAirportNames(current_line));
			count++;
			
			//airports.add(new Airport(getAirportName(this.csv_scanner.nextLine()), 0, 0));
			
		}
		System.out.println("Total: " + count);
		return airports;
	}
	
	
	public static void main(String[] args) {
		DatabaseParser parser = new DatabaseParser("C:\\Users\\johnm\\Documents\\GitHub\\AirTravelSystem\\ATS\\airports.dat.txt");
		
		ArrayList<Airport> airport = parser.parseAirports();
	}
}
