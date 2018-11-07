import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

public class LastModified {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

			try {
				//URL u = new URL(args[i]);
				URL u = new URL("http://www.daum.net");
				HttpURLConnection http = (HttpURLConnection) u.openConnection();
				http.setRequestMethod("HEAD");
				System.out.println(u + " was last modified at " + new Date(http.getLastModified()));
				
				for(int j=0; ;j++) {
					if(http.getHeaderField(j)!=null) {
						System.out.println(http.getHeaderField(j));
					}
					else {
						break;
					}
				}
				//addse to view
				InputStream raw = http.getInputStream();
				InputStream buffer = new BufferedInputStream(raw);
				Reader reader = new InputStreamReader(buffer);
				BufferedReader br = new BufferedReader(reader);
			
			}catch(MalformedURLException ex) {
				System.err.println(" is not a URL I understand");
			}catch(IOException ex) {
				System.err.println(ex);
			}
			System.out.println();
		//}
	}

}
