import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStreamCopy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(args.length != 2) {
			System.out.println("How 2 use : java FileStreamCopy FILE1 FILE2");
			System.exit(0);
		}
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			fis = new FileInputStream(args[0]);
			fos = new FileOutputStream(args[1]);
			byte[] buffer = new byte[512];
			int readcount = 0;
			while((readcount = fis.read(buffer)) != -1) {
				fos.write(buffer, 0, readcount);
			}
			System.out.println("Finish Copy.");
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}finally {
			try {
				fis.close();
			}catch(IOException ex) {}
			try {
				fos.close();
			}catch(IOException ex) {}
			
		}
		
	}

}
