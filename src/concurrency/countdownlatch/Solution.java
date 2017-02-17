package concurrency.countdownlatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class Solution {
	private ReentrantLock rl1 = new ReentrantLock();
	private ReentrantLock rl2 = new ReentrantLock();

	private int breads = 1;

	private List<Sandwitch> swes = new ArrayList<>();

	public static void main(String[] args) throws InterruptedException {

		ExecutorService es = Executors.newFixedThreadPool(10);
		CountDownLatch cdl = new CountDownLatch(10);

		Solution t = new Solution();

		for (int i = 0; i < 10; i++) {
			es.execute(() -> {
				for (int j = 0; j < 100; j++) {
					t.swes.add(t.prepareSandwitch());
				}
				cdl.countDown();
			});
		}

		cdl.await();

		for (Sandwitch s : t.swes) {
			System.out.println(s.breadIndex);
		}
	}

	public Sandwitch prepareSandwitch() {
		boolean rlb1 = false, rlb2 = false;
		String knifeUsed = "";

		while (true) {
			rlb1 = rl1.tryLock();
			if (!rlb1) {
				rlb2 = rl2.tryLock();
				if (rlb2) {
					knifeUsed = "Knife2";
					System.out.println(Thread.currentThread().getName() + " recieved lock 2");
					break;
				}
			} else {
				knifeUsed = "Knife1";
				System.out.println(Thread.currentThread().getName() + " recieved lock 1");
				break;
			}

			System.out.println(Thread.currentThread().getName() + " waiting for a Lock");
		}

		Sandwitch s = new Sandwitch();

		s.breadIndex = this.breads++;
		s.appliedJam = true;
		s.KnifeUsed = knifeUsed;

		if (rlb1) {
			rl1.unlock();
		}

		if (rlb2) {
			rl2.unlock();
		}

		return s;
	}

	static class Sandwitch {
		int breadIndex;
		String KnifeUsed = "";
		boolean appliedJam = false;
	}

}
