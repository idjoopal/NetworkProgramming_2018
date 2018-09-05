
public class ThreadJoinTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t = new Thread() {
			public void run() {
				try {
					Thread.sleep(2000);
					System.out.println("MyThread 종료");
					Thread.sleep(3000);
				}catch(Exception e) {
					
				}
			}
		};
		
		t.start();
		try {
			t.join();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("main 종료");
	}
}

// join을 하면 해당 쓰레드가 끝날 때 까지 기다려준다.
