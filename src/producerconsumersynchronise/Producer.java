package producerconsumersynchronise;

import java.util.Queue;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Producer implements Runnable {

	private Queue<UnitOfWork> queue;
	private String name;
	private int maxSize;

	public Producer(Queue<UnitOfWork> queue, String name, int maxSize) {
		this.queue = queue;
		this.name = name;
		this.maxSize = maxSize;

	}

	@Override
	public void run() {
		while (true) {
			synchronized (this.queue) {
				if (queue.size() < maxSize) {
					System.out.println(Thread.currentThread() + " :Name ->" + name + " Queue Size :" + queue.size());
					queue.add(new UnitOfWork());
					System.out.println("TOTAL NUMBER OF THREAD: " + Thread.activeCount());
				}
				// System.out.println(Thread.currentThread() + " :Name ->" + name + " Running
				// Still");
			}
		}

	}

}
