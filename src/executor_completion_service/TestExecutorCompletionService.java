package executor_completion_service;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestExecutorCompletionService {

	static class SleepingCallable implements Callable<String> {

		final String name;
		final long period;

		SleepingCallable(final String name, final long period) {
			this.name = name;
			this.period = period;
		}

		public String call() {
			try {
				Thread.sleep(period);
			} catch (InterruptedException ex) {
			}
			return name;
		}
	}

	public static void main(String[] args) {
		withoutExecutorCompletionService();
		withExecutorCompletionService();
	}

	/**
	 * 
	 */
	public static void withoutExecutorCompletionService() {
		final ExecutorService pool = Executors.newFixedThreadPool(2);
		final List<? extends Callable<String>> callables = Arrays.asList(new SleepingCallable("quick", 500),
				new SleepingCallable("slow", 5000));
		try {

			// invokeAll() Executes the given tasks, returning a list of Futures
			// holding
			// their status and results when all complete.
			for (final Future<String> future : pool.invokeAll(callables)) {
				System.out.println(future.get());
			}
		} catch (ExecutionException | InterruptedException ex) {
		}
		pool.shutdown();
	}

	/**
	 * 
	 */
	public static void withExecutorCompletionService() {
		final ExecutorService pool = Executors.newFixedThreadPool(2);
		
		final CompletionService<String> service = new ExecutorCompletionService<String>(pool);
		
		final List<? extends Callable<String>> callables = Arrays.asList(new SleepingCallable("slow", 5000),
				new SleepingCallable("quick", 500));
		
		for (final Callable<String> callable : callables) {
			service.submit(callable);
		}
		
		pool.shutdown();
		
		try {
			while (!pool.isTerminated()) {
				// take() Retrieves and removes the Future representing the next
				// completed task, waiting if none are yet present.
				final Future<String> future = service.take();
				System.out.println(future.get());
			}
		} catch (ExecutionException | InterruptedException ex) {
		}
	}

}
