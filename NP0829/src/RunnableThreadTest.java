class RunnableThread implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("Runnable �������̽��� ����");

	}

}

public class RunnableThreadTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t = new Thread(new RunnableThread());
		t.start();
		System.out.println("���� ������ ����");
	}

}
