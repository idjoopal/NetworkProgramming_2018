import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest {

	public static void main(String[] args) throws FileNotFoundException, IOException{
		// TODO Auto-generated method stub
		File file = new File("abc.txt");
		
		FileOutputStream fos = new FileOutputStream(FileDescriptor.out);
		//콘솔에 출력하겠다는 뜻.
		
		FileOutputStream fos1 = new FileOutputStream(file);
		//실제 파일에 출력하겠다는 뜻.
		
		byte[] data = {17, 68, 70, 72, (byte)'!', (byte)'\n'};
		fos.write(data);
		fos1.write(data);
		
		fos.flush();
		fos1.flush();
		
		//fos.close를 하면 OutputStream이 완전히 닫혀서 밑에있는 sysout이 동작하지 않는다.
		
		System.out.println("종료!!");
	}

}
