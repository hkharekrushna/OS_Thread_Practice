package addersubtractorexecutorpoolsynchronisemethod;



public class Adder implements Runnable{
	
	Counter count;
	
	public Adder(Counter count) {
		super();
		this.count = count;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		for(int i=0; i < 100; i++) {
			int value = count.getCount();
			System.out.println("Thread Name:"+Thread.currentThread()+ " VALUE IS " + value);
			count.incrementCount(i);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}
	
	

}
