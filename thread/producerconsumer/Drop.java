package thread.producerconsumer;

import java.util.Random;

public class Drop {
	boolean empty = true;;
	String message;
	
	//buffered length resource
	static final int BUFFER_LENGTH = 10;
	String[] messageQueue = new String[BUFFER_LENGTH];
	
	int size = 0;

	public synchronized void consume() {
		while (empty) {
			try {
				wait();
			} catch (InterruptedException ie) {
			}
		}
		Random random = new Random();
		try {
			Thread.sleep(random.nextInt(500));
		} catch (InterruptedException ie) {
		}
		empty = true;
		System.out.println("Consumed message:" + message);

		message = null;
		this.notify();
	}

	public synchronized void consumeFromQueue() {
		while (size == 0) {
			try {
				wait();
			} catch (InterruptedException ie) {
			}
		}
		Random random = new Random();
		try {
			Thread.sleep(random.nextInt(500));
		} catch (InterruptedException ie) {
		}
		String s = messageQueue[size - 1];
		System.out.println("Consumed message:" + s);
		messageQueue[size - 1] = null;
		size--;
		this.notify();
	}

	public synchronized void produce() {
		while (!empty) {
			try {
				wait();
			} catch (InterruptedException ie) {
			}
		}
		Random random = new Random();
		try {
			Thread.sleep(random.nextInt(500));
		} catch (InterruptedException ie) {
		}
		String str = "";
		for (int i = 0; i < 10; i++)
			str = str + (char) ('a' + random.nextInt(26));
		empty = false;
		message = str;
		System.out.println("Produced message:" + message);
		this.notify();
	}
	
	public synchronized void produceToTheQueue() {
		while (size==BUFFER_LENGTH) {
			try {
				wait();
			} catch (InterruptedException ie) {
			}
		}
		Random random = new Random();
		try {
			Thread.sleep(random.nextInt(500));
		} catch (InterruptedException ie) {
		}
		String str = "";
		for (int i = 0; i < 10; i++)
			str = str + (char) ('a' + random.nextInt(26));
		messageQueue[size] = str;
		System.out.println("Produced message from queue:" + str);
		size++;
		this.notify();
	}
}
