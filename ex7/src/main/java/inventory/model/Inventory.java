package inventory.model;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Inventory {
	private Map<Integer, Product> inventoryMap;
	private int size;
	
	public Inventory() {
		this.inventoryMap = new LinkedHashMap<>();
		this.size = 0;
	}
	
	public int size() {
		return this.size;
	}
	
	public void addProduct(Product product) {
		if(product == null) {
			System.err.println("Invalid product!");
			return;
		}
		
		this.inventoryMap.put(product.getProductId(), product);
		product.setProductId(size-1);
		this.size++;
	}
	
	public boolean removeProduct(int productId) {
		Product product = this.inventoryMap.remove(productId);
		
		if(product == null) {
			return false;
		}
		
		this.size--;
		return true;
	}
	
	public Product findProductById(int productId) {
		return this.inventoryMap.get(productId);
	}
	
	public List<Product> findProductsByCategory(String category) {
		Collection<Product> products = inventoryMap.values();
		
		List<Product> foundProducts = products.stream()
				.filter(product -> product.getCategory().equals(category))
				.toList();
		
		return foundProducts;
	}
	
	public List<Product> getAllProducts() {
		return new ArrayList<>(this.inventoryMap.values());
	}
	
	public void sortProductsByName() {		
		TreeMap<String, Product> sortedMap = new TreeMap<>();
		
		for(Product product: this.inventoryMap.values()) {
			sortedMap.put(product.getName(), product);
		}
		
		
		this.inventoryMap.clear();
		for(Product product: sortedMap.values()) {
			this.inventoryMap.put(product.getProductId(), product);
		}
	}
	
	public void sortProductsByPrice() {
		TreeMap<Double, Product> sortedMap = new TreeMap<>();
		
		for(Product product: this.inventoryMap.values()) {
			sortedMap.put(product.getPrice(), product);
		}
		
		
		this.inventoryMap.clear();
		for(Product product: sortedMap.values()) {
			this.inventoryMap.put(product.getProductId(), product);
		}
	}
	
	public List<Product> getLowStockProducts(int threshold) {		
		return this.filterProducts(product -> product.getQuantity() <= threshold);
	}
	
	public List<Product> filterProducts(Predicate<Product> predicate) {
		return this.getAllProducts().stream()
				.filter(predicate)
				.toList();
	}
	
	public void applyToProducts(Consumer<Product> consumer) {
		this.getAllProducts().forEach(consumer);
	}
	
	@Override
	public boolean equals(Object obj) {
		Inventory comparedProduct = (Inventory) obj;
		boolean isEqual = true;
		isEqual &= this.size == comparedProduct.size();
		
		for(int key: this.inventoryMap.keySet()) {
			isEqual &= this.inventoryMap.get(key).equals(comparedProduct.findProductById(key));
		}
		
		return isEqual;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Inventory {");

		for(Product product: this.inventoryMap.values()) {
			builder.append(product.toString());
		}
		
		builder.append("}");
		
		// TODO Auto-generated method stub
		return builder.toString();
	}
}
