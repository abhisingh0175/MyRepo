package miscellaneous.producerconsumer;

public class Consumer implements Runnable {
	Resource resource = null;

	Consumer(Resource resource) {
		this.resource = resource;
	}

	@Override
	public void run() {
		while (true) {
			if (resource.size == 0) {
				try {
					resource.wait();
				} catch (InterruptedException ie) {

				}
			}
			String item = resource.msgQ[resource.size - 1];
			resource.msgQ[resource.size - 1] = null;
			resource.size--;
			System.out.println(Thread.currentThread().getName() + " has consumed an item : " + item);
		}
	}
}
