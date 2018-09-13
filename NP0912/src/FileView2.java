import java.io.FileInputStream;

public class FileView2 {

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
			int readcount = 0;
			byte[] buffer = new byte[512];
			while((readcount=fis.read(buffer)) != -1) {
				System.out.write(buffer, 0, readcount);
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
// 버퍼로 한번에 여러바이트씩 읽으면 한바이트씩 읽는 것보다 속도가 빠르다.
// FileView2.java better than FileView.java