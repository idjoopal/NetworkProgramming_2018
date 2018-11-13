import java.net.*;
import java.util.Date;
import java.io.*;

public class DaytimeClientMultithread {

	public static void main(String[] args) {

		//String hostname = args.length > 0 ? args[0] : "utcnist.colorado.edu";
		String hostname = args.length > 0 ? args[0] : "114.70.22.18";
		//		String hostname = args.length > 0 ? args[0] : "time.nist.gov";
		Socket socket = null;
		for (int i = 0; i < 10; i++) {
			try {
				socket = new Socket(hostname, 13);
				socket.setSoTimeout(10000);
				Thread t = new DaytimeThread(socket);
				t.start();
			} catch (IOException ex) {
				System.err.println(ex);
			} 
		}
	}
	private static class DaytimeThread extends Thread {

		private Socket connection;

		DaytimeThread(Socket connection) {
			this.connection = connection;
		}

		@Override
		public void run() {
			try {
				InputStream in = connection.getInputStream();
				StringBuilder time = new StringBuilder();
				InputStreamReader reader = new InputStreamReader(in, "ASCII");
				int c;
				while ((c = reader.read()) != -1) {
					time.append((char) c);
				}
				System.out.println(this.getName() + ": " + time);
			} catch (IOException ex) {
				System.err.println(ex);
			} finally {
				try {
					connection.close();
				} catch (IOException e) {
					// ignore;
				}
			}
		}
	}
}