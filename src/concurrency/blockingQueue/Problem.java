package concurrency.blockingQueue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Problem {

	public static void main(String[] args) {
		Queue<String> queue = new ArrayDeque<>(1024);

		ExecutorService es = Executors.newFixedThreadPool(2);
		es.execute(new Producer(queue));
		es.execute(new Consumer(queue));
	}
}

class Producer implements Runnable {
	Queue<String> queue;

	public Producer(Queue queue) {
		this.queue = queue;
	}

	public void run() {
		queue.add("Yogesh");
		try {
			Thread.sleep(1000);
			queue.add("Yogesh1");
			Thread.sleep(1000);
			queue.add("Yogesh2");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

class Consumer implements Runnable {
	Queue<String> queue;

	public Consumer(Queue queue) {
		this.queue = queue;
	}

	public void run() {
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
	}
}