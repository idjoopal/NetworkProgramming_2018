package internetaddress;

import java.net.*;

public class AddressResolutionByName {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//InetAddress address = InetAddress.getByName("www.konkuk.ac.kr");
			InetAddress address = InetAddress.getByName("dna.soyoungpark.me");
			System.out.println(address);
			System.out.println(address.getHostName());
			System.out.println(address.getCanonicalHostName());
			//displayInetAddressInformation(address);
			
//			byte[] addr = {(byte)202, 30, 38, 108};
//			InetAddress address2 = InetAddress.getByAddress(addr);
			InetAddress address2 = InetAddress.getByName("202.30.38.108");
			System.out.println(address2);
			System.out.println(address2.getHostName());
			System.out.println(address2.getCanonicalHostName());
			
			InetAddress[] addresses = InetAddress.getAllByName("www.google.com");
			for (InetAddress address3 : addresses)
				System.out.println(address3);
			
		} catch (UnknownHostException ex) {
			System.out.println("Could not find www.konkuk.ac.kr");
		}

	}
	
//	private static void displayInetAddressInformation (InetAddress address) {
//		System.out.println(address);
//		System.out.println("CanonicalHostName: " + address.getCanonicalHostName());
//		System.out.println("HostName: " + address.getHostName());
//		System.out.println("HostAddress: " + address.getHostAddress());
//	}

}
