package addersubtractorexecutorpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("Thread Name:"+Thread.currentThread());
		Counter count = new Counter(0);
		
		Adder add = new Adder(count);
		Subtractor sub = new Subtractor(count);
		
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
