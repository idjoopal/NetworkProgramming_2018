import java.io.*;
import java.security.*;
import java.util.ArrayList;
<<<<<<< HEAD

import javax.xml.bind.*;
=======
>>>>>>> bd82cb85524ec7702c9c488b3e307e39ffb24856

import javax.xml.bind.*;

class ReturnDigest extends Thread {
	private String filename;
	private byte[] digest;

	public ReturnDigest(String filename) {
		this.filename = filename;
	}

	@Override
	public void run() {
		try {
			FileInputStream in = new FileInputStream(filename);
			MessageDigest sha = MessageDigest.getInstance("SHA-256");
			DigestInputStream din = new DigestInputStream(in, sha);

			while (din.read() != -1)
				;
			din.close();

			// calculate hash
			digest = sha.digest();

			// Build a string with format "filename: key"
			StringBuilder result = new StringBuilder(filename);
			result.append(": ");
			result.append(DatatypeConverter.printHexBinary(digest));
			// try {
			// Thread.sleep(1000);
			// } catch (InterruptedException ex) {}
			System.out.println(result + " in run()");

		} catch (IOException ex) {
			System.err.println(ex);
		} catch (NoSuchAlgorithmException ex) {
			System.err.println(ex);
		}

	}

	public byte[] getDigest() {
		return digest;
	}

	public String getFilename() {
		return filename;
	}

}

public class RaceConditionTest {

	/// *
	public static void main(String[] args) throws InterruptedException {
<<<<<<< HEAD
		
		ArrayList<String> filenames = new ArrayList<String>();
		filenames.add("./src/test1.txt");
		filenames.add("./src/test2.txt");
		filenames.add("./src/test3.txt");
		filenames.add("./src/test4.txt");
		filenames.add("./src/test5.txt");
		
		for (String filename : filenames) {
			//Calculate the digest
=======
		ArrayList<ReturnDigest> drThreads = new ArrayList<ReturnDigest>();

		for (String filename : args) {
			// Calculate the digest
>>>>>>> bd82cb85524ec7702c9c488b3e307e39ffb24856
			ReturnDigest dr = new ReturnDigest(filename);
			drThreads.add(dr);
			dr.start();
		}

		for (ReturnDigest dr : drThreads) {
			// Now print the result
			dr.join();
			StringBuilder result = new StringBuilder(dr.getFilename());
			result.append(": ");
			byte[] digest = dr.getDigest();
			result.append(DatatypeConverter.printHexBinary(digest));
			System.out.println(result);
		}

	}// */
}
