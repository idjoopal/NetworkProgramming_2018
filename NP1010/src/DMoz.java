import java.io.*;
import java.net.*;

public class DMoz {

  public static void main(String[] args) {
  
    String target = "";
    for (int i = 0; i < args.length; i++) {
      target += args[i] + " ";
    }
    target = target.trim();

    QueryString query = new QueryString();
    query.add("p", target);
    try {
    	//URL u = new URL("http://www.dmoz-odp.org/search/q?" + query);
    
    	//URL u = new URL("https://search.yahoo.com/search?p=java&fr=yfp-t&fp=1&toggle=1&cop=mss&ei=UTF-8");
    
    	//뒤의 것 지워도 큰 상관이 없다.
      URL u = new URL("https://search.yahoo.com/search?");
      try (InputStream in = new BufferedInputStream(u.openStream())) {
        InputStreamReader theHTML = new InputStreamReader(in);
        int c;
        while ((c = theHTML.read()) != -1) {
          System.out.print((char) c);
        } 
      }
    } catch (MalformedURLException ex) {
      System.err.println(ex);
    } catch (IOException ex) {
      System.err.println(ex);
    }
  }
}