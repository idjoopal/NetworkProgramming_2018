
public class SystemInReadTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int inChar;
		System.out.println("Enter a Character: ");
		try {
			inChar = System.in.read();
			
			System.out.write(inChar);
			
			//System.out.println(inChar);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}

}
