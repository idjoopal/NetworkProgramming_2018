package urlexample;

import java.net.*;
import java.io.*;

public class ContentTypePerferenceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			URL u = new URL("https://www.oreilly.com");
			Class<?>[] types = new Class[3];
			types[0] = String.class;
			types[1] = Reader.class;
			types[2] = InputStream.class;
			Object o = u.getContent(types);
			
			if (o instanceof String) {
				System.out.println(o);
			} else if (o instanceof Reader) {
				int c;
				Reader r = (Reader) o;
				while ((c = r.read()) != -1) System.out.print((char) c);
				r.close();
			} else if (o instanceof InputStream) {
				int c;
				InputStream in = (InputStream) o;
				while ((c = in.read()) != -1) System.out.write(c);
				in.close();
			} else {
				System.out.println("Error: unexpected type " + o.getClass());
			}
		} catch (MalformedURLException me) {
			System.err.println(me);
		} catch (IOException ie) {
			System.err.println(ie);
		}

	}

}

//https://cdn.oreillystatic.com/oreilly/images/odot_jaana_dogan_340x340.jpg
//https://www.oreilly.com
