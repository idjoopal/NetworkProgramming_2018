import java.io.FileInputStream;

public class FileView {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis();
		
		if(args.length != 1) {
			System.out.println("How to use : java FileView FILENAME");
			System.exit(0);
		}
		
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(args[0]);
			int i=0;
			while((i=fis.read()) != -1) {
				System.out.write(i);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}finally {
			try {
				fis.close();
			} catch (Exception e2) {
				// TODO: handle exception
				System.out.println(e2);
			}
		}
		long end = System.currentTimeMillis();
		
		System.out.println("\nRun-time : " + (end-start) );

	}

}
