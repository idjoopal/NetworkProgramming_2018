package internetaddress;

import java.net.*;

public class MyAddress2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			InetAddress ia = InetAddress.getLocalHost();
			String dottedQuad = ia.getHostAddress();
			System.out.println("My Address is " + dottedQuad);
		} catch (UnknownHostException ex) {
			System.out.println("I'm sorry. I don't know my own address.");
		}

	}

}
