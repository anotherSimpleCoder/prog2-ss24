package consumerProducer;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class App {
	private Queue<Integer> numbersQueue;
	private Producer producer;
	private Consumer consumer;
	
	public App(ExtractionOrder extractionOrder) {
		switch(extractionOrder) {
			case FIFO:
				this.numbersQueue = new LinkedList<Integer>();
				break;
			case NATURAL_INTEGER_ORDER:
				this.numbersQueue = new PriorityQueue<>();
		}
		
		this.producer = new Producer();
		this.consumer = new Consumer();
	}
	
	public void start() {
		Random random = new Random();
		for(int i = 0; i < 10000; i++) {
			if(random.nextInt(2) > 0) {
				int quersumme = this.producer.produce();
				numbersQueue.add(quersumme);
			} else {
				if(!numbersQueue.isEmpty()) {
					continue;
				}
				
				int takenOutNumber = numbersQueue.poll();
				this.consumer.consume(takenOutNumber);
			}
		}
	}
}
