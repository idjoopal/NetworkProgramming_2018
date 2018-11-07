import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class URLPrinter {
	public static void main (String[] args) {
		try {
			// 39 page Example 
			URL u = new URL("http://www.lolcats.com/");
			URLConnection uc = u.openConnection();
			
			if(!uc.getDoInput()) {
				uc.setDoInput(true);
			}
			if(!uc.getDoOutput()) {
				uc.setDoOutput(true);
			}
			uc.setAllowUserInteraction(true);
			System.out.println("Connection timeout: " + uc.getConnectTimeout());
			System.out.println("Read timeout: " + uc.getReadTimeout());
			
			uc.setConnectTimeout(5555);
			uc.setReadTimeout(45000);
			
			if(!URLConnection.getDefaultAllowUserInteraction()) {
				URLConnection.setDefaultAllowUserInteraction(true);
			}
			uc.setUseCaches(false);
			if(uc.getDefaultUseCaches()) {
				uc.setDefaultUseCaches(false);
			}
			uc.addRequestProperty("Hello", "it's me; hey\\");
			uc.addRequestProperty("Hello2", "it's me; hey\\");
			Map<String, List<String>> map = uc.getRequestProperties();
			System.out.println(map.getClass());
			System.out.println(uc.getRequestProperties());
			InputStream in = uc.getInputStream();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
