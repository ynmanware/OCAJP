package racecondition;

class RaceCondition2 {

	public static void main(String[] args) throws InterruptedException {

		
		long start = System.currentTimeMillis();
		
		LongWrapper2 LongWrapper2 = new LongWrapper2(0L);
		
		Runnable r = () -> {
			
			for (int i = 0 ; i < 1_00000 ; i++) {
				LongWrapper2.incrementValue();
			}
		};
		
		Thread[] threads = new Thread[1_0000];
		for (int i = 0 ; i < threads.length ; i++) {
			threads[i] = new Thread(r);
			threads[i].start();
		}
		
		for (int i = 0 ; i < threads.length ; i++) {
			threads[i].join();
		}
		
		System.out.println("Total time: " + (System.currentTimeMillis() - start));
		
		System.out.println("Value = " + LongWrapper2.getValue());
	}
}
