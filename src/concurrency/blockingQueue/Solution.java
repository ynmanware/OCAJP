package concurrency.blockingQueue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Solution {

	public static void main(String[] args) {
		BlockingQueue<String> queue = new ArrayBlockingQueue<>(1024);

		ExecutorService es = Executors.newFixedThreadPool(2);
		es.execute(new Producer(queue));
		es.execute(new Consumer(queue));
	}

	static class Producer implements Runnable {
		BlockingQueue<String> queue;

		public Producer(BlockingQueue queue) {
			this.queue = queue;
		}

		public void run() {

			try {
				queue.put("Yogesh");
				Thread.sleep(1000);
				queue.put("Yogesh1");
				Thread.sleep(1000);
				queue.put("Yogesh2");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	static class Consumer implements Runnable {
		BlockingQueue<String> queue;

		public Consumer(BlockingQueue queue) {
			this.queue = queue;
		}

		public void run() {
			try {
				System.out.println(queue.take());
				System.out.println(queue.take());
				System.out.println(queue.take());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}
