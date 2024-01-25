package pkg01_java_net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Class01_InetAddress {
	
	public static void main(String[] args) {
		
		try {
			InetAddress address1 = InetAddress.getByName("gdu.co.kr");
			System.out.println("IP주소 : " + address1.getHostAddress());
			System.out.println("도메인 : " + address1.getHostName());
			
			InetAddress address2 = InetAddress.getByAddress(new byte[] {(byte)142, (byte)250, (byte)206, (byte)228});
			System.out.println("IP주소 : " + address2.getHostAddress());
			System.out.println("도메인 : " + address2.getHostName());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
	}
}
