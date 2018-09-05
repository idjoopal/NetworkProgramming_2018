class AdvanceStopThread implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub

		try {
			while (!Thread.currentThread().isInterrupted()) {
				System.out.println("Thread is alive..");
				Thread.sleep(500);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			System.out.println("Thread is Dead..");
		}
	}
}

public class AdvanceStopThreadTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("# Start AdvanceStopThreadTest.java");
		AdvanceStopThreadTest astt = new AdvanceStopThreadTest();
		astt.process();
	}

	public void process() {
		AdvanceStopThread ast = new AdvanceStopThread();
		Thread thread = new Thread(ast);
		thread.start();
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		thread.interrupt();
	}

}
