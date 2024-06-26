package consumerProducer;

import java.util.Random;

public class Producer {
	Random random;
	
	public Producer() {
		this.random = new Random();
	}
	
	public int produce() {
		return this.random.nextInt(0, 1000);
	}
}
