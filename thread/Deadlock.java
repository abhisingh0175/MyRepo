package thread;

public class Deadlock {

	/*
	 * Simple deadlock problem Two friends bow each other and each of them is
	 * also trying to return his bow to another, simultaneously.
	 */
	static class Friend {
		private final String name;

		public Friend(String name) {
			this.name = name;
		}

		public String getName() {
			return this.name;
		}

		public synchronized void bow(Friend bower) {
			System.out.format("%s: %s" + "  has bowed to me!%n", this.name, bower.getName());
			System.out.println("Trying to bow him back");
			bower.bowBack(this);
		}

		public synchronized void bowBack(Friend bower) {
			System.out.format("%s: %s" + " has bowed back to me!%n", this.name, bower.getName());
		}
	}

	public static void main(String[] args) {
		final Friend alphonse = new Friend("Alphonse");
		final Friend gaston = new Friend("Gaston");
		new Thread(new Runnable() {
			public void run() {
				alphonse.bow(gaston);
			}
		}).start();

		new Thread(new Runnable() {
			public void run() {
				gaston.bow(alphonse);
			}
		}).start();
	}

}