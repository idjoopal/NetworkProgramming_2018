class ExtendThread extends Thread{
	public void run() {
		System.out.println("Thread Ŭ������ ���");
	}
}
public class ExtendThreadTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExtendThread et = new ExtendThread();
		et.start();
	}

}
