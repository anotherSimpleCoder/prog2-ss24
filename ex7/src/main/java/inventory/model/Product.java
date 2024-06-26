package inventory.model;

public class Product {
	private int productId;
	private String name;
	private String category;
	private double price;
	private int quantity;
	
	public Product(int productId, String name, String category, double price, int quantity) {
		this.productId = productId;
		this.name = name;
		this.category = category;
		this.price = price;
		this.quantity = quantity;
	}
	
	public Product(String name, String category, double price, int quantity) {
		this.name = name;
		this.category = category;
		this.price = price;
		this.quantity = quantity;
	}
	
	public String getCategory() {
		return category;
	}
	
	public String getName() {
		return name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public int getProductId() {
		return productId;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return String.format("Product{id: %d, name: %s, category: %s, price: %.2f, quantity: %d}", this.productId, this.name, this.category, this.price, this.quantity);
	}
}
