import java.io.*;
import java.net.*;

public class AllHeaders {

	public static void main(String[] args) {
		try {
			URL u = new URL("http://www.oreilly.com");
			URLConnection uc = u.openConnection();
			//add a for loop that retrieves all header fields and prints them on console
			
			int n=0;
			while(uc.getHeaderField(n)!=null) {
				System.out.println(uc.getHeaderFieldKey(n) + " : "+uc.getHeaderField(n));
				System.out.println();
				n++;
			}
			
			
		} catch (MalformedURLException ex) {
			System.err.println(args[0] + " is not a URL I understand.");
		} catch (IOException ex) {
			System.err.println(ex);
		}
		System.out.println();
	} 
}