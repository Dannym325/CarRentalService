import java.util.ArrayList;
import java.util.Collections;

public class Car implements Comparable<Car> {
	
	private String sipp;
	private String name;
	private Double price;
	private String supplier;
	private Double rating;
	
	public Car(String sipp, String name, Double price, String supplier, Double rating) {
		this.sipp = sipp;
		this.name = name;
		this.price = price;
		this.supplier = supplier;
		this.rating = rating;
				
	}
	
	// getters
	public String getSipp() {
		return sipp;
	}
	
	public String getName() {
		return name;
	}
	
	public Double getPrice() {
		return price;
	}
	
	public Double getRating() {
		return rating;
	}
	
	public String getSupplier() {
		return supplier;
	}
	
	//setters
	public void setSipp(String sipp) {
		this.sipp = sipp;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public void setRating(Double rating) {
		this.rating = rating;
	}
	
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	@Override
	public int compareTo(Car otherCar) {
		if(otherCar == null) {
			throw new NullPointerException("Attempted to compare " + this + " to null");
		} else if (!this.getClass().equals(otherCar.getClass())) {
            throw new ClassCastException("Class Cast Exception");
        } else if (this.price < otherCar.price) {
            return -1;
        } else if (this.price > otherCar.price) {
            return 1;
        }
		return 0;
	}
	
	/**
	 * Method that uses natural ordering to print out cars in price ascending order
	 * @param cars
	 */
	public void sortPriceAcending(ArrayList<Car> cars) {
		
		Collections.sort(cars);
		System.out.println("Natural sorting of cars on price:");
		for (Car car : cars) {
			System.out.println("{" + car.getName() + "} - {" + car.getPrice() + "}");
		}
		System.out.println();
	}
	
	/**
	 * Method to display each car and break down its SIPP into its meanings.
	 * @param cars
	 */
	public void printOutCarSpecs(ArrayList<Car> cars) {
		String carType, doors, transmission, fuelAirCon; 
		
		for (Car car : cars) {
			String sipp = car.getSipp();
	        String[] parts = sipp.split("");
	        
	        // find the type of car by the first letter of the SIPP.
	        carType = getCarType(parts[0]);
	        
	        // finds the car type and number of doors by the second letter of the SIPP
	        doors = getCarDoorType(parts[1]);
	        
	        // finds the car transmission type by the third letter of the SIPP
	        transmission = getCarTranmission(parts[2]);
	        
	        // find the fuel and air con type by the forth letter of the SIPP
	        fuelAirCon = getCarFuelAirCon(parts[3]);
	        
	        String[] arrFuelAir = fuelAirCon.split("/");
	        String fuelType = arrFuelAir[0];
	        String airCon = arrFuelAir[1];
	        
	        System.out.println("{" + car.getName() + "} - {" + car.getSipp() + "} - {" 
	        + carType + "} - {" + doors + "} - {" + transmission + "} - {" + fuelType + "} - {" + airCon + "}" );
	        
		}
	}
	
	public String getCarDoorType(String doors) {
        switch(doors) {
	        case "B" : doors = "2 Doors"; break;
	        case "C" : doors = "4 Doors"; break;
	        case "D" : doors = "5 Doors"; break;
	        case "W" : doors = "Estate"; break;
	        case "T" : doors = "Convertible"; break;
	        case "F" : doors = "SUV"; break;
	        case "P" : doors = "Pick up"; break;
	        case "V" : doors = "Passenger Van"; break;
	        default : doors = "Unknown";
        }
        return doors;
	}
	
	public String getCarTranmission(String transmission) {
        switch(transmission) {
	        case "M" : transmission = "Manual"; break;
	        case "A" : transmission = "Automatic"; break;
	        default : transmission = "Unknown";
	    }
		return transmission;
	}
	
	public String getCarFuelAirCon(String fuelAirCon) {
		switch(fuelAirCon) {
	        case "N" : fuelAirCon = "Petrol/no AC"; break;
	        case "R" : fuelAirCon = "Petrol/AC"; break;
	        default : fuelAirCon = "Unknown/Unknown";
	    }
		return fuelAirCon;
	}
	
	public String getCarType(String type) {
		String carType;
        switch(type) {
	        case "M" : carType = "Mini"; break;
	        case "E" : carType = "Economy"; break;
	        case "C" : carType = "Compact"; break;
	        case "I" : carType = "Intermediate"; break;
	        case "S" : carType = "Standard"; break;
	        case "F" : carType = "Full Size"; break;
	        case "P" : carType = "Premium"; break;
	        case "L" : carType = "Luxury"; break;
	        case "X" : carType = "Special"; break;
	        default : carType = "Unknown";
	    }
        return carType;
	}
	
	/**
	 * Finds the highest rated car per type and finds the supplier
	 * @param cars
	 */
	public void sortBySupplierRating(ArrayList<Car> cars) {
		
		String[] carTypes = {"M", "E", "C", "I", "S", "F", "P", "L", "X"};
		// loops around all the car types
		for(int i = 0; i <= carTypes.length - 1; i++) {
			Double highestRated = 0.0;
			int highestRatedIndex = 0;
			String sipp = null;
			// loops around all the cars
			for(int j = 0; j < cars.size(); j++) {
				sipp = cars.get(j).getSipp();
				String[] sippParts = sipp.split("");
				// checking if the car type matches the car in the first loop
				if(sippParts[0].equalsIgnoreCase(carTypes[i])) {
					// checks if the current car has the highest rating
					if(cars.get(j).getRating() > highestRated) {
						highestRated = cars.get(j).getRating();
						highestRatedIndex = j;
					}
				}	
			}
				System.out.println("{" + cars.get(highestRatedIndex).getName() + "} - {" + getCarType(carTypes[i]) + "} - {" + 
						cars.get(highestRatedIndex).getSupplier() + "} - {" + cars.get(highestRatedIndex).getRating() + "}");
		}
		
	}
	
	public void getVehicleScore(ArrayList<Car> cars) {
		int manual = 1, automatic = 5, airCon = 2, totalScore = 0;
		
		for(int i = 0; i < cars.size(); i++) {
			
		}
	}

}
