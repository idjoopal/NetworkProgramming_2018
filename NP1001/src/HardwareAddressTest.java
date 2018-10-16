import java.net.*;

public class HardwareAddressTest {

	public static void main(String[] args) throws UnknownHostException, SocketException {
		// TODO Auto-generated method stub
		InetAddress address = InetAddress.getLocalHost();
		System.out.println("IP address: " + address.getHostAddress());
		NetworkInterface ni = NetworkInterface.getByInetAddress(address);
		System.out.println("MAC address: " + getMACIdentifier(ni));

	}
	
	public static String getMACIdentifier(NetworkInterface ni) {
		StringBuilder identifier = new StringBuilder();
		try {
			byte[] macBuffer = ni.getHardwareAddress();
			if (macBuffer != null) {
				for (int i = 0; i < macBuffer.length; i++) {
					identifier.append(String.format("%02X%s", macBuffer[i],
							(i < macBuffer.length - 1) ? "-" : ""));
				}
			} else {
				return "---";
			}
		} catch (SocketException ex) {
			ex.printStackTrace();
		}
		return identifier.toString();
	}

}
