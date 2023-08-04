package addersubtractor;

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
			int setValue = value + i;
			System.out.println("Thread Name:"+Thread.currentThread());
			count.setCount(setValue);
			System.out.println("Count Value"+count.getCount());
		}
		
		
		
	}
	
	

}
