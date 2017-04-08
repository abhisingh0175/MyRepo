package thread;

public class BasicThreads extends Thread implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(100);
			} catch (Exception e) {
			} finally {
				System.out.println("I am a basic thread");
			}
		}
	}

	public static void main(String[] args) {
		Thread myThread = new Thread(new NewRunnable());
		myThread.start();
		myThread.stop();
	}
}
