package thread.producerconsumer;

import java.util.Random;

public class Producer extends Thread {
	Drop drop;

	Producer(Drop drop) {
		this.drop = drop;
	}

	@Override
	public void run() {
		Random random = new Random();
		while (true) {
			try {
				Thread.sleep(random.nextInt(500));
			} catch (InterruptedException ie) {
			}
			//drop.produce();
			drop.produceToTheQueue();;
		}
	}
}
