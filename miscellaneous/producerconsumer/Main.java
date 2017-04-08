package miscellaneous.producerconsumer;

/*Didn't work out, go to thread.producerconsumer package for a running example
*/
public class Main {

	public static void main(String[] args) {
		Resource resource = new Resource();

		Runnable producer = new Producer(resource);
		new Thread(producer).start();

		Runnable consumer = new Consumer(resource);
		new Thread(consumer).start();
	}

}
