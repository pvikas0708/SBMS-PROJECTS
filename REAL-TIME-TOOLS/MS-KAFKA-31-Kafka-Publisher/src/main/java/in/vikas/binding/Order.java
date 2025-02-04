package in.vikas.binding;

public class Order {

	private String id;
	private double price;
	private String email;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", price=" + price + ", email=" + email + "]";
	}
	
	
}
