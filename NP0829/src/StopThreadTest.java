class StopThread implements Runnable {
	private boolean stopped = false;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (!stopped) {
			System.out.println("THread is alive..");
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		System.out.println("Thread is Dead..");
	}

	public void stop() {
		System.out.println("플래그 전환");
		stopped = true;
	}

}

public class StopThreadTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("# Start StopThreadTest.java");
		StopThreadTest stt = new StopThreadTest();
		stt.process();
	}

	public void process() {
		StopThread st = new StopThread();
		Thread thread = new Thread(st);
		thread.start();
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("플래그 변경 신호");
		st.stop();
	}

}
