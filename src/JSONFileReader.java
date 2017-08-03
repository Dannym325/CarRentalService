import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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

	public static void main(String[] args) {

        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader("src/vehicles.json"));

            JSONObject jsonObject = (JSONObject) obj;
            // System.out.println(jsonObject);

            JSONObject search = (JSONObject) jsonObject.get("Search");
            JSONArray vehicleList = (JSONArray) search.get("VehicleList");

            for (int i = 0; i < vehicleList.size(); i++) {
                JSONObject vehicle = (JSONObject) vehicleList.get(i);
                System.out.println("*--------------*");
                System.out.println("sipp: " + vehicle.get("sipp"));
                System.out.println("name: " + vehicle.get("name"));
                System.out.println("price: " + vehicle.get("price"));
                System.out.println("supplier: " + vehicle.get("supplier"));
                System.out.println("rating: " + vehicle.get("rating"));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } 
    }

}
