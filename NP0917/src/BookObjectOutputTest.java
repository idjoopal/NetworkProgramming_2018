import java.io.*;
import java.util.ArrayList;

public class BookObjectOutputTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		ArrayList list = new ArrayList();
		Book b1 = new Book("a0001", "자바완성", "홍길동", 10000);
		Book b2 = new Book("a0002", "스트럿츠", "김유신", 20000);
		Book b3 = new Book("a0003", "기초 EJB", "김성박", 25000);
		
		list.add(b1);
		list.add(b2);
		list.add(b3);
		
		try {
			fos = new FileOutputStream("booklist.dat");
			oos = new ObjectOutputStream(fos);
			
			oos.writeObject(list);
			
			System.out.println("저장되었습니다.");
		} catch (Exception ex) {
			System.out.println(ex);
		} finally {
			try {
				oos.close();
				fos.close();
			} catch (IOException ioe) {
				System.out.println(ioe);
			}
		}

	}

}
