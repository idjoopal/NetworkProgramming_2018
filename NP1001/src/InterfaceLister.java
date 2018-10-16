import java.net.*;
import java.util.*;

public class InterfaceLister {

	public static void main(String[] args) throws UnknownHostException, SocketException {
		NetworkInterface ni = NetworkInterface.getByName("en0");
		if (ni != null) {
			System.out.println(ni);
		} else {
			System.err.println("No such interface: eth0");
		}
		
		InetAddress ia = InetAddress.getByName("127.0.0.1");
		NetworkInterface ni2 = NetworkInterface.getByInetAddress(ia);
		if (ni2 != null) {
			System.out.println(ni2);
		} else {
			System.err.println("That's weird. No local loopback address");
		}
		
		System.out.println("\\nEnumerate every NIsn");
		Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
		while (interfaces.hasMoreElements()) {
			NetworkInterface ni3 = interfaces.nextElement();
			System.out.println(ni3);               
		}  
	}
}
