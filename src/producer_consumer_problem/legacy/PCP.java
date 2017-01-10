package producer_consumer_problem.legacy;

/**
 * @author Yogesh.Manware -> Legacy code (Java 1.4) -> Producer will produce any
 *         kind of product and Consumer must consume the product as it is
 *         produced, one at a time
 */

public class PCP {

	public static void main(String[] args) {
		Counter counter = new Counter();

		Producer producer = new Producer(counter, 1);
		Consumer consumer = new Consumer(counter, 1);

		producer.start();
		consumer.start();

	}

}

class Counter {
	private String product;
	private boolean available = false;

	public synchronized String getProduct() {
		while (!available) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		notifyAll();
		available = false;
		return product;
	}

	public synchronized void setProduct(String product) {
		while (available) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		available = true;
		notifyAll();
		this.product = product;
	}
}

// Producer
class Producer extends Thread {
	private Counter counter;
	private int id;

	public Producer(Counter counter, int id) {
		this.counter = counter;
		this.id = id;
	}

	@Override
	public void run() {
		int i = 1;
		while (true) {
			counter.setProduct("Samosa#" + i);
			System.out.println("Producer #" + this.id + " put: " + "Samosa#" + i);

			try {
				sleep((long) (Math.random() * 100));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			i++;
		}

	}
}

class Consumer extends Thread {
	private Counter counter;
	private int id;

	public Consumer(Counter counter, int id) {
		this.counter = counter;
		this.id = id;
	}

	@Override
	public void run() {
		while (true) {
			System.out.println("Consumer #" + this.id + " got: " + counter.getProduct());
		}
	}
}
