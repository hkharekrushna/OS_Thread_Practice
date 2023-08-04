package addersubtractorexecutorpoollock;

import java.util.concurrent.locks.ReentrantLock;

public class Adder implements Runnable{
	
	Counter count;
	ReentrantLock lockAdder;
	
	public Adder(Counter count,ReentrantLock lockAdder) {
		super();
		this.count = count;
		this.lockAdder = lockAdder;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		for(int i=0; i < 100; i++) {
			lockAdder.lock();
			int value = count.getCount();
			int setValue = value + i;
			System.out.println("Thread Name:"+Thread.currentThread()+ " VALUE IS " + value);
			count.setCount(setValue);
			//System.out.println("Count Value"+count.getCount());
			lockAdder.unlock();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}
	
	

}
