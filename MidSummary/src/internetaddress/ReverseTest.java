package internetaddress;

import java.net.*;

public class ReverseTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			InetAddress ia = InetAddress.getByName("172.217.161.36");
			System.out.println(ia.getCanonicalHostName());
			System.out.println(ia.getHostName());
			System.out.println();
			
			InetAddress ia2 = InetAddress.getByName("www.konkuk.ac.kr");
			System.out.println(ia2.getHostName());
			System.out.println(ia2.getCanonicalHostName());
			System.out.println(ia2.getHostName());
		} catch (UnknownHostException ex) {
			
		}

	}

}
