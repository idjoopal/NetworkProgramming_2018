import java.io.*;
import java.util.ArrayList;

public class BookObjectInputTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		
		try {
			fis = new FileInputStream("booklist.dat");
			ois = new ObjectInputStream(fis);
			
			ArrayList list = (ArrayList)ois.readObject();
			Book b1 = (Book)list.get(0);
			Book b2 = (Book)list.get(1);
			Book b3 = (Book)list.get(2);
			
			System.out.println(b1.toString());
			System.out.println(b2.toString());
			System.out.println(b3.toString());
		} catch (Exception ex) {
			System.out.println(ex);
		} finally {
			try {
				ois.close();
				fis.close();
			} catch (IOException ioe) {
				System.out.println(ioe);
			}
		}
	}

}
