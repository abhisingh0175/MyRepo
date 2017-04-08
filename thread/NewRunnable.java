package thread;

public class NewRunnable implements Runnable{

	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(100);
			} catch (Exception e) {
			} finally {
				System.out.println("I am New Runnable");
			}
		}
	}	

}
