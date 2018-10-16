package internetaddress;

import java.net.*;

public class MyAddress {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			InetAddress address = InetAddress.getLocalHost();
			System.out.println(address);
			System.out.println(address.getHostAddress());
		
		} catch (UnknownHostException ex) {
			System.out.println("Could not find this computer's address");
		}
	}


}

//byte[] address = {107, 23, (byte) 216, (byte)196};
//InetAddress ia = InetAddress.getByAddress(address);
//InetAddress iaNamed = InetAddress.getByAddress("named.com", address);
