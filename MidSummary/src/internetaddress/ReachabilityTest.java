package internetaddress;

import java.net.*;
import java.io.*;

public class ReachabilityTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//InetAddress address = InetAddress.getByName("www.konkuk.ac.kr");
			byte[] addr = {(byte)202, 30, 38, 108};
			//byte[] addr = {10, 0, 1, 4};
			InetAddress address = InetAddress.getByAddress(addr);
			int timeout = 3000;
			int ttl = 10;
			
			if (address.isReachable(timeout)) {
				System.out.println(address.getHostName() + " CAN BE reached within " + timeout + "ms");
			} else {
				System.out.println(address.getHostName() + " CANNOT BE reached within " + timeout + "ms");
			}
		} catch (UnknownHostException ex) {
			System.err.println("unknown hostname");
		} catch (IOException e) {
			System.err.println(e);
		}
	}

}
