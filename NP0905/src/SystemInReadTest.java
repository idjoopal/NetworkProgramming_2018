import java.io.IOException;

public class SystemInReadTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int inChar;
		System.out.println("Enter a Character:");
		try {
			inChar = System.in.read();
			System.out.println("You entered ");
			System.out.println(inChar);
		}catch(IOException e) {
			System.out.println("Error reading from user");
		}
	}

}
