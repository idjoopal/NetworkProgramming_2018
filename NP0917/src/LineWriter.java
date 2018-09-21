import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class LineWriter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(args.length != 1) {
			System.out.println("How to use : java LineWriter FILENAME");
			System.exit(0);
		}
		
		BufferedReader br = null;
		PrintWriter pw = null;
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			pw = new PrintWriter(new BufferedWriter(new FileWriter(args[0])));
			String line = null;
			while((line = br.readLine()) != null) {
				System.out.println("Readed String : " + line);
				pw.println(line);
			}
		}catch (Exception ex) {
			// TODO: handle exception
			System.out.println(ex);
		}finally {
			try {
				pw.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

}
