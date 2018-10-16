package urlexample;

import java.net.*;

public class RelativeURLTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			URL u1 = new URL("http://www.ibiblio.org/javafaq/index.html");
			URL u2 = new URL(u1, "mailinglists.html");
			System.out.println(u1);
			System.out.println(u2);
		} catch (MalformedURLException ex) {
			System.err.println(ex);
		}

	}

}
