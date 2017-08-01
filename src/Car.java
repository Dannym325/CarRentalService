
public class Car {
	
	private String sipp;
	private String name;
	private Double price;
	private Double rating;
	
	public Car(String sipp, String name, Double price, Double rating) {
		this.sipp = sipp;
		this.name = name;
		this.price = price;
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

}
