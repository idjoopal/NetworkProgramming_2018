
public class ThreadJoinTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t = new Thread() {
			public void run() {
				try {
					Thread.sleep(2000);
					System.out.println("MyThread ����");
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
		System.out.println("main ����");
	}
}

// join�� �ϸ� �ش� �����尡 ���� �� ���� ��ٷ��ش�.
