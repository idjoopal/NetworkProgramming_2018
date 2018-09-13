import java.io.*;

public class ByteArrayTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fis = new FileInputStream(args[0]);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] buffer = new byte[512];
		int readcount = 0;
		
		// 파일로부터 읽어들인 byte배열을 ByteArrayOutputStream에 쓴다
		while((readcount = fis.read(buffer)) != -1) {
			baos.write(buffer, 0, readcount);
		}
		System.out.println("baos.length: " + baos.size());
		// toByteArray() 이용하여 내부공간의 내용을 byte array로 반환
		byte[] fileArray = baos.toByteArray();
		
		ByteArrayInputStream bais = new ByteArrayInputStream(fileArray);
		
		while((readcount = bais.read(buffer)) != -1) {
			System.out.write(buffer, 0, readcount);
		}

	}

}
