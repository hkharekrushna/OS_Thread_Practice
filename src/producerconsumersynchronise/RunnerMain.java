package producerconsumersynchronise;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

public class RunnerMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("RUNNING WITH JAVA VERSION " + System. getProperty("java.version"));
		Queue<UnitOfWork> queue= new ArrayDeque<>();
		
		Producer p = new Producer(queue,"hk",30);
		
		Set<String> producerNames = Set.of("P1","P2","P3");
		Set<String> consumerNames = Set.of("C1","C2","C3","C4");
		int maxSize=20;
		
		Set<Producer> producerSet= producerNames
				.stream()
				.map(name -> new Producer(queue,name,maxSize))
				.collect(Collectors.toSet());
		
		Set<Consumer> consumerSet= consumerNames
				.stream()
				.map(name -> new Consumer(queue,name))
				.collect(Collectors.toSet());
		
		producerSet.forEach(producer -> new Thread(producer).start());
		consumerSet.forEach(consumer -> new Thread(consumer).start());	
		
	}

}
