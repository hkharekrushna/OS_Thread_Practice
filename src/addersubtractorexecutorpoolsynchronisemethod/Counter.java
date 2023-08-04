package addersubtractorexecutorpoolsynchronisemethod;

public class Counter {
	
	private int count;
	
	public Counter(int count) {
		this.count=count;
	}
	
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count; 
	}
	
	public synchronized  void incrementCount(int value) {
		setCount(getCount()+value);
	}
}


