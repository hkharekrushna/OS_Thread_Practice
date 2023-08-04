package addersubtractorexecutorpoollock;

import java.util.concurrent.locks.ReentrantLock;

public class Subtractor implements Runnable{
	
	Counter count;
	ReentrantLock lockSubtractor;
	
	public Subtractor(Counter count,ReentrantLock lockSubtractor) {
		super();
		this.count = count;
		this.lockSubtractor = lockSubtractor;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		for(int i=0; i < 100; i++) {
			lockSubtractor.lock();
			int value = count.getCount();
			System.out.println("Thread Name:"+Thread.currentThread()+ " VALUE IS " + value);
			int setValue = value - i;
			count.setCount(setValue);
			//System.out.println("Count Value"+count.getCount());
			lockSubtractor.unlock();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	

}
