package addersubtractorexecutorpoolsynchroniseblock;


public class Subtractor implements Runnable{
	
	Counter count;
	
	public Subtractor(Counter count) {
		super();
		this.count = count;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		for(int i=0; i < 100; i++) {
			synchronized (count) {
				int value = count.getCount();
				System.out.println("Thread Name:"+Thread.currentThread()+ " VALUE IS " + value);
				int setValue = value - i;
				count.setCount(setValue);
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	

}
