
public class DaemonThreadTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t = new Thread() {
			public void run() {
				try {
					Thread.sleep(5000);
					System.out.println("MyThread ����");
					
				}catch(Exception e) {
					
				}
			}
		};
		
		t.setDaemon(true);
		t.start();
		
		System.out.println("main ����");
	}

}

// ���󽺷���� 5�ʰ� ��ٸ� �� ���Ḧ ���������,
// ������ �̹� ����Ǿ �׳� ���� ����Ǿ������.