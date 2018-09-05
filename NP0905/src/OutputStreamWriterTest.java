import java.io.*;

public class OutputStreamWriterTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File file = new File("abccc.txt");
		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(bw);
		
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw1 = new BufferedWriter(osw);
		PrintWriter pw1 = new PrintWriter(bw1);
		
		pw.println("파일에 적는다");
		pw1.println("화면에 뿌린다");
		
		pw.close();
		pw1.close();

	}

}
