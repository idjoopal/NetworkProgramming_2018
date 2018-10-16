import java.net.*;
import java.util.*;

public class InterfaceLister2 {

	public static void main(String[] args) throws UnknownHostException, SocketException {
		NetworkInterface ni = NetworkInterface.getByName("en0");
		if (ni != null) {
			System.out.println(ni);
		} else {
			System.err.println("No such interface: eth0");
		}
		Enumeration<InetAddress> addresses = ni.getInetAddresses();
		for (InetAddress element : Collections.list(addresses)) {
			System.out.println(element);
		}
		
		System.out.println("\ngetByInetAddress");
		InetAddress ia = InetAddress.getByName("127.0.0.1");
		NetworkInterface ni2 = NetworkInterface.getByInetAddress(ia);
		if (ni2 != null) {
			System.out.println(ni2);
		} else {
			System.err.println("No local loopback address");
		}
		
		System.out.println("\nEnumerate every NIs");
		Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
		for (NetworkInterface element : Collections.list(interfaces)) {
			System.out.println(element);
			Enumeration<InetAddress> inetAddresses = element.getInetAddresses();
			for (InetAddress ia2 : Collections.list(inetAddresses)) {
				System.out.println(ia2);
			}
		}
	}
}
