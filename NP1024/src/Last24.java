import java.io.*;
import java.net.*;
import java.util.*;

public class Last24 {

  public static void main (String[] args) {

    // Initialize a Date object with the current date and time
    Date today = new Date();
    long millisecondsPerDay = 24 * 60 * 60 * 1000;

    for (int i = 0; i < args.length; i++) {
      try {
        URL u = new URL(args[i]);
        URLConnection uc = u.openConnection();
        System.out.println("Original if modified since: "
            + new Date(uc.getIfModifiedSince()));
        uc.setIfModifiedSince((new Date(today.getTime() 
            - millisecondsPerDay)).getTime());
        System.out.println("Will retrieve file if it's modified since "
            + new Date(uc.getIfModifiedSince()));
        try (InputStream in = new BufferedInputStream(uc.getInputStream())) {
          Reader r = new InputStreamReader(in);
          BufferedReader br = new BufferedReader(r);
          
          //int c;
          String line;
          while((line = br.readLine()) != null) {
          //while ((c = r.read()) != -1) {
        	  System.out.println(line);
        	  //System.out.print((char) c);
          } 
          System.out.println();
        }
      } catch (IOException ex) {
        System.err.println(ex);
      }
    }
  }
}