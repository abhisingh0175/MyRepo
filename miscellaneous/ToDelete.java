package miscellaneous;

public class ToDelete {
	static void printThreadMessage(String message) {
		System.out.println(Thread.currentThread().getName() + ": " + message);
	}

	public static void main(String[] args) {
		Runnable thread = new Runnable() {
			public void run() {
				int count = 1;
				String[] messages = { "a message", "piku", "welcome", "keku" };
				while (!Thread.interrupted()) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException ie) {
						printThreadMessage("Someone interrupted me! " + count++);
					}
					printThreadMessage(messages[(int) (Math.random() * 10) % 4]);
				}
			}
		};
		long time = System.currentTimeMillis();

		Thread t = new Thread(thread);
		t.start();
		try {
			t.join(20000);
		} catch (InterruptedException ie) {
			printThreadMessage("...interrupted!");
		}
		while (t.isAlive()) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ie) {
				printThreadMessage("...interrupted!");
			}
			printThreadMessage("Waiting for the other thread!");
			if (time > 1000 * 60 * 60)
				t.interrupt();
		}
	}

}
