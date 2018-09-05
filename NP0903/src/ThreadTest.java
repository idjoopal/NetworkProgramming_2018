
public class ThreadTest extends Thread{

	public void run() {
		for(int i=1; i<=10;i++) {
			System.err.println(getName()+": "+i);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadTest t1 = new ThreadTest();
		ThreadTest t2 = new ThreadTest();
		
		//MIN 우선순위 가장 낮게
		//MAX 우선순위 가장 높게
		t1.setPriority(Thread.MIN_PRIORITY);
		t2.setPriority(Thread.MAX_PRIORITY);
		
		t1.start();
		t2.start();
	}

}
