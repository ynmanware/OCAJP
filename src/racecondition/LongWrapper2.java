package racecondition;

import java.util.concurrent.atomic.AtomicLong;

public class LongWrapper2 {

	private Object key = new Object();
	private AtomicLong l = new AtomicLong();

	public LongWrapper2(long l) {
		this.l.set(l);
	}

	public long getValue() {
		return l.get();
	}

	public void incrementValue() {
		l.incrementAndGet();
	}
}
