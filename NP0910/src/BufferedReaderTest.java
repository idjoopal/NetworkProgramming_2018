import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class BufferedReaderTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		String line = "";
		//String line = br.readLine();
		
		while(!line.equals("End")) {
			line = br.readLine();
			System.out.println("String from keyboard : "+ line + "\n");
		}
		
	}

}
