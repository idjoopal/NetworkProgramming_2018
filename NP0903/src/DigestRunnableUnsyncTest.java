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
			
			//java ������ �˻��Ѵ�.
			//�׳� ����ϸ� �����峢�� ������ ������� ������� ����.
			//�׷��� synchronize ���
			
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
