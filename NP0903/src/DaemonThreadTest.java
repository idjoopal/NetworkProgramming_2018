
public class DaemonThreadTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t = new Thread() {
			public void run() {
				try {
					Thread.sleep(5000);
					System.out.println("MyThread 종료");
					
				}catch(Exception e) {
					
				}
			}
		};
		
		t.setDaemon(true);
		t.start();
		
		System.out.println("main 종료");
	}

}

// 데몬스레드는 5초간 기다린 뒤 종료를 출력하지만,
// 메인이 이미 종료되어서 그냥 같이 종료되어버린다.