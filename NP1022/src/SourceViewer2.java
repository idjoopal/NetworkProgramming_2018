
import java.io.*;
import java.net.*;

public class SourceViewer2 {

	public static void main (String[] args) {
		try {
			// Open the URLConnection for reading
			URL u = new URL("https://www.oreilly.com");
			URLConnection uc = u.openConnection();
			try (InputStream raw = uc.getInputStream()) { // autoclose
				InputStream buffer = new BufferedInputStream(raw);       
				// chain the InputStream to a Reader				
				Reader reader = new InputStreamReader(buffer);

				// add
				BufferedReader br = new BufferedReader(reader);
				// int c;
				String line = null;
				
				// while ((c = br.read()) != -1) {
				while ((line = br.readLine()) != null) {
						System.out.println(line);
				}
			}
		} catch (MalformedURLException ex) {
			System.err.println(args[0] + " is not a parseable URL");
		} catch (IOException ex) {
			System.err.println(ex);
		}
	}
}