package producer_consumer_problem.blocking_q;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author Yogesh.Manware -> Legacy code (Java 1.4) -> Producer will produce any
 *         kind of product and Consumer must consume the product as it is
 *         produced, one at a time
 */

public class PCP {

	public static void main(String[] args) {

		// counter or queue which can hold just product at a time
		BlockingQueue<String> counter = new ArrayBlockingQueue<>(1);

		Producer producer = new Producer(counter, 1);
		Consumer consumer = new Consumer(counter, 1);

		producer.start();
		consumer.start();

	}

}

// Producer
class Producer extends Thread {
	private BlockingQueue<String> counter;
	private int id;

	public Producer(BlockingQueue<String> counter, int id) {
		this.counter = counter;
		this.id = id;
	}

	@Override
	public void run() {
		int i = 1;
		while (i < 10) {
			try {
				System.out.println("Producer #" + this.id + " put: " + "Samosa#" + i);
				counter.put("Samosa#" + i); // note the method PUT
				i++;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}

class Consumer extends Thread {
	private BlockingQueue<String> counter;
	private int id;

	public Consumer(BlockingQueue<String> counter, int id) {
		this.counter = counter;
		this.id = id;
	}

	@Override
	public void run() {
		while (true) {
			try {
				// note the method TAKE
				System.out.println("Consumer #" + this.id + " got: " + counter.take());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
