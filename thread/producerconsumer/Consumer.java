package thread.producerconsumer;

import java.util.Random;

class Consumer extends Thread {
	Drop drop;

	Consumer(Drop drop) {
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
			//drop.consume();
			drop.consumeFromQueue();
		}
	}
}
