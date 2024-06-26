package inventory.view;

import inventory.model.Inventory;

public class App {
	private Inventory inventory = new Inventory();
	private CLI cli  = new CLI(inventory);
	
	public App() {
		this.inventory = new Inventory();
		this.cli  = new CLI(inventory);
	}
	
	public void start() {
		this.cli.start();
	}
	
	public static void main(String[] args) {
		App app = new App();
		app.start();
	}
}
