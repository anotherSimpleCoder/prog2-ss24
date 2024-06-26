package inventory.view;

import inventory.model.Inventory;

public class App {
	private Inventory inventory;
	private CLI cli;
	
	public App() {
		this.inventory = new Inventory();
		this.cli = new CLI(this.inventory);
	}
	
	public void start() {
		this.cli.start();
	}
}
