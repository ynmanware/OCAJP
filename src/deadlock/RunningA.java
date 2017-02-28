package deadlock;

public class RunningA {

	public static void main(String[] args) throws InterruptedException {

		A a = new A();
		
		Runnable R1 = () -> a.a();
		Runnable R2 = () -> a.b();
		
		Thread t1 = new Thread(R1);
		t1.start();
		
		Thread t2 = new Thread(R2);
		t2.start();

		t1.join();
		t2.join();
				
	}
}
