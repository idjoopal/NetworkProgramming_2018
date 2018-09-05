class Producer extends Thread {
	private Buffer blank;
	
	public Producer(Buffer b) {
		blank = b;
	}
	public void run() {
		for (int i=0; i<10; i++) {
			blank.put(i);
			
//			System.out.println("Producer: Produced" + i);
//			try {
//				sleep((int)(Math.random()*100));
//			} catch (InterruptedException e) {
//				
//			}
		}
	}
}

class Consumer extends Thread {
	private Buffer blank;
	
	public Consumer(Buffer b) {
		blank = b;
	}
	public void run() {
		int value = 0;
		
		for (int i=0; i<10; i++) {
			value = blank.get();
			
			System.out.println("Consumer: Consumed" + value);
		}
	}
}

class Buffer {
	private int contents;
	private boolean available = false;
	
	public synchronized int get() {
		while (available == false) {
			try {
				wait();
			} catch (InterruptedException e) {}
		}
		System.out.println("Consumer############ : Consumed" + contents);
		notify();
		available = false;
		
		return contents;
	}

	public synchronized void put(int value) {
		while (available == true) {
			try {
				wait();
			} catch (InterruptedException e) {}
		}
		
		contents = value;
		System.out.println("Producer############ : Produced" + contents);
		notify();
		available = true;
	}
}


public class ProducerConsumer {

	public static void main(String[] args) {
		Buffer b = new Buffer();
		Producer p1 = new Producer(b);
		Consumer c1 = new Consumer(b);
		
		p1.start();
		c1.start();

	}

}
