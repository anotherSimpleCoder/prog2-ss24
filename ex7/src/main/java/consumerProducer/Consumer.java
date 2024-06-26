package consumerProducer;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Consumer {
	private TreeMap<Integer, ArrayList<Long>> timesForQuersummen = new TreeMap<>();
	
	public int consume(int number) {
		long timestamp = System.currentTimeMillis();
		int sum = quersumme(number);
		
		if(timesForQuersummen.get(sum) == null) {
			timesForQuersummen.put(sum, new ArrayList<>());
		}
		
		timesForQuersummen.get(sum).add(timestamp);
		
		return sum;
	}
	
	private int quersumme(int number) {
		int sum = 0;
		
		while(number != 0) {
			sum += number % 10;
			number /= 10;
		}
		
		return sum;
	}
	
	public int numberOfDifferentResults() {
		return this.timesForQuersummen.size();
	}
	
	public int numberOfOccurences(int numberToFind) {
		ArrayList<Long> numberTimestamps = this.timesForQuersummen.get(numberToFind);
		return numberTimestamps.size();
	}
	
	public List<Integer> getCrossTotalsAscending() {
		return this.timesForQuersummen.keySet().stream()
				.collect(Collectors.toList());
	}
	
	public List<Integer> getCrossTotalsDescending() {
		return this.timesForQuersummen.keySet().stream()
				.sorted((quersumme1, quersumme2) -> {
					if(quersumme1 > quersumme2) {
						return -1;
					} else if(quersumme1 < quersumme2) {
						return 1;
					} else {
						return 0;
					}
				})
				.collect(Collectors.toList());
	}
	
	public ArrayList<Long> getTimestampsForResult(int result) {
		return this.timesForQuersummen.get(result);
	}
}
