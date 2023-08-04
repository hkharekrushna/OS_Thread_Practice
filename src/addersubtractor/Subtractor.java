package addersubtractor;

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
			int value = count.getCount();
			System.out.println("Thread Name:"+Thread.currentThread());
			int setValue = value - i;
			count.setCount(setValue);
			System.out.println("Count Value"+count.getCount());
		}
		
	}
	
	

}
