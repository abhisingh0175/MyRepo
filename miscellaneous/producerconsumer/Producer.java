package miscellaneous.producerconsumer;

public class Producer implements Runnable {
	Resource resource = null;

	Producer(Resource resource) {
		this.resource = resource;
	}

	private static String randomString() {
		String string = "";
		char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'x', 'y', 'z' };
		for (int i = 0; i < 5; i++)
			string = string + charArray[((int) Math.random() * 10) % charArray.length];
		return string;
	}

	@Override
	public void run() {
		while (true) {
			if (resource.size == 10) {
				try {
					resource.wait();
				} catch (InterruptedException ie) {

				}
			}
			String item = randomString();
			resource.msgQ[resource.size] = item;
			resource.size++;
			System.out.println(Thread.currentThread().getName() + " has produced an item : " + item);

		}
	}
}
