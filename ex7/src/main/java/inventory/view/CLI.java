package inventory.view;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import inventory.model.Inventory;
import inventory.model.Product;

public class CLI {
	private Inventory inventory;
	private Prompt prompt;
	private ArrayList<String> options;
	
	public CLI(Inventory inventory) {
		this.inventory = inventory;
		this.prompt = new Prompt();
		this.options = new ArrayList<String>() {{
			add("Add product");
			add("Remove product");
			add("Search product by ID");
			add("Show products by category");
			add("Show all products");
			add("Sort products by name");
			add("Sort products by price");
			add("Show lowest stock products");
			add("Filter products by given criterion");
			add("Raise product prices by given percentage");
			add("Exit");
		}};
	}
	
	public void start() {
		int choice;
		
		while(true) {
			System.out.println();
			System.out.println("===========================");
			System.out.println("INVENTORY MANAGEMENT SYSTEM");
			System.out.println("===========================");
			System.out.println();
					
			choice = prompt.promptChoice("Please enter your choice: ", this.options);
			
			this.routeByChoice(choice);
		}
	}
	

	
	public void addProduct() {
		Product productToAdd;
		String name, category;
		double price;
		int quantity;
		
		System.out.println();
		System.out.println("===========");
		System.out.println("ADD PRODUCT");
		System.out.println("===========");
		System.out.println();
		
		name = prompt.promptString("Please enter the name of your product: ");
		category = prompt.promptString("Please enter the category of your product: ");
		price = prompt.promptDouble("Please enter the price of your product: ");
		quantity = prompt.promptInt("Please enter the quantity of your product: ");
		
		productToAdd = new Product(name, category, price, quantity);
		this.inventory.addProduct(productToAdd);
	}
	
	public void removeProduct() {
		int idToRemove;
		
		System.out.println();
		System.out.println("==============");
		System.out.println("REMOVE PRODUCT");
		System.out.println("==============");
		System.out.println();
		
		idToRemove = prompt.promptInt("Please enter the ID of the product you want to remove: ");
		this.inventory.removeProduct(idToRemove);
	}
	
	public void searchProductsById() {
		int idToSearch;
		
		System.out.println();
		System.out.println("====================");
		System.out.println("SEARCH PRODUCT BY ID");
		System.out.println("====================");
		System.out.println();
		
		idToSearch = prompt.promptInt("Please enter the ID of the product, you're searching for: ");
		Product foundProduct = this.inventory.findProductById(idToSearch);
		System.out.println(foundProduct);
	}
	
	public void showProductsByCategory() {
		String categoryToShow;
		
		System.out.println();
		System.out.println("=========================");
		System.out.println("SHOW PRODUCTS BY CATEGORY");
		System.out.println("=========================");
		System.out.println();

		categoryToShow = prompt.promptString("Please enter the category you're looking for: ");		
		List<Product> foundProducts = this.inventory.findProductsByCategory(categoryToShow);
		System.out.println(foundProducts);
	}
	
	public void showAllProducts() {
		System.out.println();
		System.out.println("========");
		System.out.println("PRODUCTS");
		System.out.println("========");
		System.out.println();
		
		this.printAllProducts();
	}
	
	public void sortProductsByName() {
		System.out.println();
		System.out.println("================");
		System.out.println("PRODUCTS BY NAME");
		System.out.println("================");
		System.out.println();
		
		this.inventory.sortProductsByName();
		this.printAllProducts();
	}
	
	public void sortProductsByPrice() {
		System.out.println();
		System.out.println("=================");
		System.out.println("PRODUCTS BY PRICE");
		System.out.println("=================");
		System.out.println();
		
		this.inventory.sortProductsByPrice();
		this.printAllProducts();
	}

	
	public void showLowestQuantityProducts() {
		int quantityThreshold;
		
		System.out.println();
		System.out.println("=============================");
		System.out.println("SHOW LOWEST QUANTITY PRODUCTS");
		System.out.println("=============================");
		System.out.println();
		
		quantityThreshold = prompt.promptInt("Please enter the threshold for the lowest quantity: ");
		List<Product> lowQuantityProducts = this.inventory.getLowStockProducts(quantityThreshold);
		System.out.println(lowQuantityProducts);
	}
	
	public void showProductsByCustomFilter() {
		System.out.println();
		System.out.println("======================");
		System.out.println("SHOW FILTERED PRODUCTS");
		System.out.println("======================");
		System.out.println();
		
		ArrayList<String> critertionOptions = new ArrayList<String>() {{
			add("name");
			add("price");
			add("quantity");
		}};

		List<Product> filteredProducts = new LinkedList<>();
		
		int criterionChoice = prompt.promptChoice("Please enter the filter criterion:", critertionOptions);
		switch(criterionChoice) {
			case 0: {
				String nameToFilter = prompt.promptString("Enter the name to filter by: ");
				filteredProducts = this.inventory.filterProducts(product -> product.getName().equals(nameToFilter));
				break;
			}
			
			case 1: {
				double priceToFilter = prompt.promptDouble("Enter the price to filter by: ");
				filteredProducts = this.inventory.filterProducts(product -> product.getPrice() == priceToFilter);
				break;
			}
			
			case 2: {
				int quantityToFilter = prompt.promptInt("Enter the quantity to filter by: ");
				filteredProducts = this.inventory.filterProducts(product -> product.getQuantity() == quantityToFilter);
				break;
			}
		}
		
		System.out.println(filteredProducts);
	}
	
	public void raiseProductPriceByPercentage() {
		double percentage;
		
		System.out.println();
		System.out.println("=======================================");
		System.out.println("RAISE PRODUCT PRICE BY GIVEN PERCENTAGE");
		System.out.println("=======================================");
		System.out.println();
		
		percentage = prompt.promptDouble("Please enter the increase percentage (0;100]: ");
		
		this.inventory.applyToProducts(product -> {
			double newPrice = product.getPrice() * (1 + (percentage / 100));
			product.setPrice(newPrice);
		});
		
		this.printAllProducts();
	}
	
	public void exit() {
		return;
	}
	
	private void routeByChoice(int choice) {
		switch(choice) {
			case 0:
				this.addProduct();
				break;
				
			case 1:
				this.removeProduct();
				break;
				
			case 2:
				this.searchProductsById();
				break;
				
			case 3:
				this.showProductsByCategory();
				break;
				
			case 4:
				this.showAllProducts();
				break;
				
			case 5:
				this.sortProductsByName();
				break;
				
			case 6:
				this.sortProductsByPrice();
				break;
				
			case 7:
				this.showLowestQuantityProducts();
				break;
				
			case 8:
				this.showProductsByCustomFilter();
				break;
				
			case 9:
				this.raiseProductPriceByPercentage();
				break;
				
			case 10:
				System.exit(0);
		
			default:
				System.err.println("Invalid choice!");
		}
	}
	
	private void printAllProducts() {
		List<Product> allProducts = this.inventory.getAllProducts();
		System.out.println(allProducts);
	}
	
	
}
