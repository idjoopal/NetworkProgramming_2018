import java.io.FileInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

public class DigestRunnableUnsyncTest implements Runnable {
	private String filename;

	public DigestRunnableUnsyncTest(String filename) {
		this.filename = filename;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			FileInputStream in = new FileInputStream(filename);
			MessageDigest sha = MessageDigest.getInstance("SHA-256");
			DigestInputStream din = new DigestInputStream(in, sha);
			while (din.read() != -1);
			din.close();
			byte[] digest = sha.digest();
			
			//java 파일을 검색한다.
			//그냥 출력하면 쓰레드끼리 꼬여서 순서대로 출력하지 않음.
			//그래서 synchronize 사용
			
			synchronized (System.out) {
				System.out.print(in+": ");
				System.out.print(DatatypeConverter.printHexBinary(digest));
				System.out.println();
			}
		} catch (IOException ex) {
			// TODO: handle exception
			System.err.println(ex);
		}catch (NoSuchAlgorithmException ex) {
			// TODO: handle exception
			System.err.println(ex);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(String filename : args) {
			DigestRunnableUnsyncTest dr = new DigestRunnableUnsyncTest(filename);
			Thread t = new Thread(dr);
			t.start();
		}

	}

}
