import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutputStreamTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileOutputStream fis = null;
		DataOutputStream dis = null;
		
		try {
			fis = new FileOutputStream("data.bin");
			dis = new DataOutputStream(fis);
			dis.writeBoolean(true);
			dis.writeByte((byte)5);
			dis.writeInt(100);
			dis.writeDouble(200.5);
			dis.writeUTF("hello world");
			System.out.println("Saved.");
		}catch (Exception ex) {
			// TODO: handle exception
			System.out.println(ex);
		}finally {
			try {
				fis.close();
			}catch (IOException e) {
				// TODO: handle exception
			}
			
			try {
				dis.close();
			}catch (IOException e) {
				// TODO: handle exception
			}
		}

	}

}
