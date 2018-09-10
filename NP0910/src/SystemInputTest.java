
public class SystemInputTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=0;
		
		try {
			while((i=System.in.read()) != -1) {
				System.out.println(i);
				System.out.write(+i);
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
}
// 엔터를 치면 read를 통해 한바이트씩 읽어온다.
// 읽어온 바이트값을 int형태로 출력한다.
