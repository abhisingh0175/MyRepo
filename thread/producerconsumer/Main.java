package thread.producerconsumer;

public class Main {

	public static void main(String[] args) {
		Drop drop = new Drop();
		new Producer(drop).start();
		new Consumer(drop).start();
	}

}
