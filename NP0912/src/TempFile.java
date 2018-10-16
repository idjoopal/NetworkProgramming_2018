import java.io.*;

public class TempFile {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		File f = File.createTempFile("tmp_", ".dat");
		System.out.println("60초동안 멈춰있습니다.");
		
		System.out.println("생성된 임시파일 이름 : " + f.getName());
		System.out.println("생성된 임시파일 경로 : " + f.getParent());
		f.deleteOnExit();
		
		Thread.sleep(60000);

	}

}
