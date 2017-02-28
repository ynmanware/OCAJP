package racecondition;

class RaceCondition {

	public static void main(String[] args) throws InterruptedException {

		
		long start = System.currentTimeMillis();
		
		LongWrapper longWrapper = new LongWrapper(0L);
		
		Runnable r = () -> {
			
			for (int i = 0 ; i < 1_00000 ; i++) {
				longWrapper.incrementValue();
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
		
		System.out.println("Value = " + longWrapper.getValue());
	}
}
