package ex6;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import consumerProducer.Consumer;

public class ConsumerTests {
	private Consumer testConsumer;
	
	@BeforeEach
	public void setup() {
		this.testConsumer = new Consumer();
	}
	
	@Test
	public void testConsume() {
		int testValue = 54;
		int quersumme = this.testConsumer.consume(testValue);
		
		assertEquals(9, quersumme);
		assertEquals(1, this.testConsumer.numberOfOccurences(9));
	}
	
	@Test
	public void testNumberOfDifferentResults() {
		int[] testValues = new int[] {
				13,12,51,66,9
		};
		Random random = new Random();
		
		for(int testValue: testValues) {
			this.testConsumer.consume(testValue);
		}
		
		assertEquals(testValues.length, this.testConsumer.numberOfDifferentResults());
	}
	
	@Test
	public void testGetCrossTotalsAscending() {
		Random random = new Random();
		ArrayList<Integer> randomValues = new ArrayList<>();
	
		for(int i = 0; i < 100; i++) {
			randomValues.add(random.nextInt());
		}
		
		List<Integer> ascendingValues = this.testConsumer.getCrossTotalsAscending();
		for(int i = 1; i < ascendingValues.size(); i++) {
			int previousValue = ascendingValues.get(i-1);
			int currentValue = ascendingValues.get(i);
			
			assertTrue(previousValue < currentValue);
		}
	}
	
	@Test
	public void getCrossTotalsDescending() {
		Random random = new Random();
		ArrayList<Integer> randomValues = new ArrayList<>();
	
		for(int i = 0; i < 100; i++) {
			randomValues.add(random.nextInt());
		}
		
		List<Integer> ascendingValues = this.testConsumer.getCrossTotalsDescending();
		for(int i = 1; i < ascendingValues.size(); i++) {
			int previousValue = ascendingValues.get(i-1);
			int currentValue = ascendingValues.get(i);
			
			assertTrue(previousValue > currentValue);
		}
	}
}
