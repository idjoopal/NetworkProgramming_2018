import java.io.*;

public class FileInputStreamTest {

	public static void main(String[] args) throws FileNotFoundException, IOException{
		// TODO Auto-generated method stub
		///*
		File file = new File("abc.txt");
		FileInputStream fis = new FileInputStream(file);
		byte[] by = new byte[70000];//[65536];
		int count = fis.read(by);
		//*/
		for (int i = 0; i < count; i++) {
			System.out.println(i + " : " + (char)by[i]);
		}
		fis.close();

	}

}
