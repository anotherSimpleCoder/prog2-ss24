package inventory.view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Prompt {
	private Scanner scanner;
	
	public Prompt() {
		this.scanner = new Scanner(System.in);
	}
	
	public String promptString(String message) {
		String input = "";
		boolean invalidInput = true;
		
		while(invalidInput) {
			System.out.print(message);
			input = this.scanner.next();

			if(input.isEmpty()) {
				System.err.print("Please enter a valid value!");
			} else {
				invalidInput = false;
			}
		}
		
		return input;
	}
	
	public double promptDouble(String message) {
		double input = 0.0;
		boolean invalidInput = true;
		
		while(invalidInput) {
			try {
				System.out.print(message);
				input = this.scanner.nextDouble();
				
				invalidInput = false;
			} catch(InputMismatchException e) {
				System.err.print("Please enter a valid value!");
				invalidInput = true;
			}
		}
		
		return input;
	}
	
	public int promptInt(String message) {
		int input = 0;
		boolean invalidInput = true;
		
		while(invalidInput) {
			try {
				System.out.print(message);
				input = this.scanner.nextInt();
				
				invalidInput = false;
			} catch(InputMismatchException e) {
				System.err.print("Please enter a valid value!");
				invalidInput = true;
			}
		}
		
		return input;
	}
	
	public int promptChoice(String message, ArrayList<String> options) {
		int input = -1;
		boolean invalidInput = true;
		
		while(invalidInput) {
			System.out.println();
			
			for(int optionsIndex = 0; optionsIndex < options.size(); optionsIndex++) {
				System.out.printf("%d) %s \n", optionsIndex, options.get(optionsIndex));
			}
			
			System.out.println();
			input = this.promptInt(message);
			
			if(0 > input && input >= options.size()) {
				System.err.println("Invalid choice!");
			} else {
				invalidInput = false;
			}
		}
		
		return input;
	}
}
