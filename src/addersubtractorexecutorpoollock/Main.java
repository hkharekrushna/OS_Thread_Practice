package addersubtractorexecutorpoollock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("Thread Name:"+Thread.currentThread());
		Counter count = new Counter(0);
		
		ReentrantLock lock = new ReentrantLock();
		Adder add = new Adder(count,lock);
		Subtractor sub = new Subtractor(count, lock);
		
		ExecutorService executor= Executors.newCachedThreadPool();
		executor.execute(add);
		executor.execute(sub);
		
		executor.shutdown();
		try {
			executor.awaitTermination(100, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Count value in Main function "+count.getCount());
		

	}

}
