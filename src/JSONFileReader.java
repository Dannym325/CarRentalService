import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * 
 * This class will be used to read JSON files into the Java project
 * 
 * @author Daniel Madeley
 *
 */

public class JSONFileReader {
	
	public ArrayList<Car> readFileIntoCarObjects() {
		JSONParser parser = new JSONParser();
        ArrayList<Car> cars = new ArrayList<Car>();
        Car[] carsArr;

        try {
            Object obj = parser.parse(new FileReader("src/vehicles.json"));

            JSONObject jsonObject = (JSONObject) obj;
            // System.out.println(jsonObject);

            JSONObject search = (JSONObject) jsonObject.get("Search");
            JSONArray vehicleList = (JSONArray) search.get("VehicleList");
            
            
            for (int i = 0; i < vehicleList.size(); i++) {
            	
                JSONObject vehicle = (JSONObject) vehicleList.get(i);
                	
                String sipp = vehicle.get("sipp").toString();
                String name = vehicle.get("name").toString();
                Double price = Double.parseDouble(vehicle.get("price").toString());
                String supplier = vehicle.get("supplier").toString();
                Double rating = Double.parseDouble(vehicle.get("rating").toString());
                
            	Car car = new Car(sipp, name, price, supplier, rating); // create a new car object

            	cars.add(car); // add the new object to the array
            	
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
		return cars;	
	}
		
	
	public static void main(String[] args) {
		Car car = new Car(null, null, null, null, null);
		ArrayList<Car> cars;
        JSONFileReader reader = new JSONFileReader();
        
        cars = reader.readFileIntoCarObjects();
        car.sortPriceAcending(cars);

        

    }

}
