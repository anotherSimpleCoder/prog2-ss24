package ex6;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Predicate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import inventory.model.Inventory;
import inventory.model.Product;

public class InventoryTests {
	private Inventory testInventory;
	
	@BeforeEach
	public void setup() {
		this.testInventory = new Inventory();
		Random random = new Random();
		
		for(int iterationIndex = 0; iterationIndex < 26; iterationIndex++) {
			char letter = (char)(65 + iterationIndex);
			String productName = String.format("%c Product", letter);
			String category = (iterationIndex % 2 == 0) ? "even": "odd";
			double price = random.nextDouble(1, 100);
			int quantity = (iterationIndex % 20);
			
			Product testProduct = new Product(iterationIndex, productName, category, price, quantity);
			this.testInventory.addProduct(testProduct);
		}
	}

	@Test
	public void testFindProductById() {
		//Search for products
		Random randomGenerator = new Random();
		int searchIndex = randomGenerator.nextInt(1, 26);
		Product foundProduct = this.testInventory.findProductById(searchIndex);
		assertNotNull(foundProduct);
		
		//Remove those products
		this.testInventory.removeProduct(searchIndex);
		
		//Redo the search and check for false
		foundProduct =  this.testInventory.findProductById(searchIndex);
		assertNull(foundProduct);
	}
	
	public void testFindProductsByCategory() {
		String testCategory = "even";
		List<Product> fetchedProdcuts = this.testInventory.findProductsByCategory(testCategory);
		
		for(Product product: fetchedProdcuts) {
			assertEquals(product.getCategory(), testCategory);
		}
	}
	
	@Test
	public void testGetAllProducts() {
		List<Product> fetchedProducts = this.testInventory.getAllProducts();
		assertEquals(fetchedProducts.size(), 26);
	}
	
	@Test
	public void testSortProductsByName() {
		this.testInventory.sortProductsByName();
		List<Product> sortedProducts = this.testInventory.getAllProducts();
		
		for(int i = 1; i < sortedProducts.size(); i++) {
			Product previousProduct = sortedProducts.get(i-1);
			Product currentProduct = sortedProducts.get(i);
			int comparisonResult = (previousProduct.getName().compareTo(currentProduct.getName()));
			
			System.out.println(comparisonResult);
		}
	}
	
	@Test
	public void testSortProductsByPrice() {
		this.testInventory.sortProductsByPrice();
		List<Product> sortedProducts = this.testInventory.getAllProducts();
		
		for(int i = 1; i < sortedProducts.size(); i++) {
			Product previousProduct = sortedProducts.get(i-1);
			Product currentProduct = sortedProducts.get(i);
			assertTrue(previousProduct.getPrice() < currentProduct.getPrice());
		}
	}
	
	@Test
	public void testGetLowStockProducts() {
		int testThreshold = 10;
		List<Product> tenStockProducts = this.testInventory.getLowStockProducts(testThreshold);
		
	
		for(Product product: tenStockProducts) {
			assertTrue(product.getQuantity() <= testThreshold);
		}
	}
	
	@Test
	public void testFilterProducts() {
		Predicate<Product> testPredicate = (product) -> product.getPrice() % 2 == 0;
		List<Product> filteredProducts = this.testInventory.filterProducts(testPredicate);
		
		for(Product product: filteredProducts) {
			assertTrue(testPredicate.test(product));
		}
	}
	
	@Test
	public void testApplyToProducts() {
		List<Product> productBuffer = new ArrayList<>();
		Consumer<Product> testConsumer = product -> productBuffer.add(product);
		
		this.testInventory.applyToProducts(testConsumer);
		
		for(int listIndex = 1; listIndex < this.testInventory.size(); listIndex++) {
			Product bufferProduct = productBuffer.get(listIndex);
			Product listProduct = this.testInventory.findProductById(listIndex);
			
			assertEquals(bufferProduct, listProduct);
		}
	}
}
