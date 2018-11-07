import java.net.*;
import java.io.*;

public class DictClient3 {
	public static void main(String[]args) {
		String host = "dict.org";
		try {
			Socket soc = new Socket(host,2628);
			OutputStream out = soc.getOutputStream();
			Writer writer = new OutputStreamWriter(out, "UTF-8");
			writer = new BufferedWriter(writer);
			InputStream in = soc.getInputStream();
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(in, "UTF-8"));
			String request = "DEFINE fd-eng-lat gold";//syntax: DEFINE DB query
			writer.write(request);
			writer.flush();
			soc.shutdownOutput();
			

			for (String line = reader.readLine(); line != null; line = reader.readLine()) {
				System.out.println(line);
			}

			soc.close();
		} catch (UnknownHostException e) {
			System.out.println("Cannot found the host at "+host);
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}