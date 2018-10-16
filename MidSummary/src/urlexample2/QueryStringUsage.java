package urlexample2;

import java.net.URLDecoder;
import java.io.UnsupportedEncodingException;


public class QueryStringUsage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueryString qs = new QueryString();
		qs.add("hl",  "en");
		qs.add("as_q", "사과");
		qs.add("as_epq",  "I/O");
		String url = "https://www.google.com/search?" + qs;
		System.out.println(url);
		
		try {
			String output = URLDecoder.decode(url, "UTF-8");
			System.out.println(output);
		} catch (UnsupportedEncodingException ex) {
			
		}
	}
}
