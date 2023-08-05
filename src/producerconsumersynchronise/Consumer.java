package producerconsumersynchronise;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Queue;

@AllArgsConstructor
@Getter
public class Consumer implements Runnable {

	private Queue<UnitOfWork> queue;
	private String name;

	public Consumer(Queue<UnitOfWork> queue, String name) {
		this.queue = queue;
		this.name = name;

	}

	@Override
	public void run() {
		while (true) {
			synchronized (this.queue) {

				if (queue.size() > 0) {
					System.out.println(Thread.currentThread() + " :Name ->" + name + "Queue Size: " + queue.size());
					queue.remove();
				}
				// System.out.println(Thread.currentThread() + " :Name ->" + name + " Running
				// Still");
			}
		}

	}

}
