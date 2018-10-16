package urlexample;

import java.net.*;

public class URLEquality {

	public static void main (String[] args) {
		try {
			URL www = new URL ("http://www.ibiblio.org/");
			URL ibiblio = new URL("http://ibiblio.org/");
			if (ibiblio.equals(www)) {
				System.out.println("equals(): " + ibiblio + " is the same as " + www);
			} else {
				System.out.println("equals(): " + ibiblio + " is not the same as " + www);
			}
			if (ibiblio.sameFile(www)) {
				System.out.println("sameFile(): " + ibiblio + " is the same as " + www);
			} else {
				System.out.println("sameFile(): " + ibiblio + " is not the same as " + www);
			}
			URL www1 = new URL ("http://www.ncsa.uiuc.edu/HTMLPrimer.html#GS");
			URL ibiblio1 = new URL("http://www.ncsa.uiuc.edu/HTMLPrimer.html#HD");
			if (ibiblio1.equals(www1)) {
				System.out.println("equals(): " + ibiblio1 + " is the same as " + www1);
			} else {
				System.out.println("equals(): " + ibiblio1 + " is not the same as " + www1);
			}
			if (ibiblio1.sameFile(www1)) {
				System.out.println("sameFile(): " + ibiblio1 + " is the same as " + www1);
			} else {
				System.out.println("sameFile(): " + ibiblio1 + " is not the same as " + www1);
			}
		} catch (MalformedURLException ex) {
			System.err.println(ex);
		}
	}
}