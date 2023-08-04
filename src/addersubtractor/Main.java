package addersubtractor;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("Thread Name:"+Thread.currentThread());
		Counter count = new Counter(0);
		
		Adder add = new Adder(count);
		Subtractor sub = new Subtractor(count);
		
		Thread tA = new Thread(add);
		Thread tS = new Thread(sub);
		
		
		tA.start();
		tA.setName("Adder Thread");
		tS.start();
		tS.setName("Subtractor Thread");
		
		try {
			tA.sleep(100);
			tS.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Count value in Main function "+count.getCount());
		
		

	}

}
