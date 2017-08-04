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

}
