import java.net.*;
import java.io.*;

//import org.omg.CORBA.portable.InputStream;

public class SourceViewerSimpleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputStream in = null;
		try {
//			URL u = new URL("http://www.lolcats.com");
			URL u = new URL("http://www.lolcats.com/images/logo.png");
			in = u.openStream();
			int c;
			while ((c = in.read()) != -1) System.out.write(c);
		} catch (IOException ex) {
			System.err.println(ex);
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException e) {
				
			}
		}

	}

}
