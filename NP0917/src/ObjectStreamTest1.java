import java.io.*;
import java.util.Vector;


public class ObjectStreamTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		Vector v = new Vector();
		Vector v1 = new Vector();
		Vector v2 = new Vector();
		Vector v3 = new Vector();
		
		v1.addElement(new String("data 1"));
		v1.addElement(new String("data 2"));
		v1.addElement(new String("data 3"));
		v2.addElement(new String("data 4"));
		
		v3.addElement(v2);
		v.addElement(v1);
		v.addElement(v3);
		
		try {
			fos = new FileOutputStream("object.dat");
			oos = new ObjectOutputStream(fos);
			
			oos.writeObject(v);
			oos.reset();
			System.out.println("저장되었습니다");
		} catch (Exception ex) {
			
		} 
		finally {
			try {
				oos.close();
				fos.close();
			} catch (IOException ioe) {}
		}

	}

}
