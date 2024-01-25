package pkg01_java_net;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Class04_InputStream {

	public static void method1() {
		String spec = "https://www.google.com/";
		URL url = null;
		HttpURLConnection con = null;
		
		BufferedReader in = null;
		
		try {
			
			url = new URL(spec);
			con = (HttpURLConnection) url.openConnection();
			
			if(con.getResponseCode() != HttpURLConnection.HTTP_OK) {
				throw new RuntimeException(spec + "접속 불가");
			}
			
			in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			
			String line = null;
			
			StringBuilder sb = new StringBuilder();
			while((line = in.readLine()) != null) {
				sb.append(line).append('\n');
			}
			
			System.out.println(sb.toString());
			
			in.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(con != null)
				con.disconnect();
		}
	}
	
	public static void method2() {
		
		String spec = "https://upload.wikimedia.org/wikipedia/commons/3/3a/Cat03.jpg";
		URL url = null;
		HttpURLConnection con = null;
		
		File dir = new File("\\storage");
		if(!dir.exists()) {
			dir.mkdirs();
		}
		File file = new File(dir, "cat.jpg");
		
		BufferedInputStream in = null;
		BufferedOutputStream out = null;
		
		try {
			
			url = new URL(spec);
			con = (HttpURLConnection)url.openConnection();
			
			if(con.getResponseCode() != HttpURLConnection.HTTP_OK) {
				throw new RuntimeException(spec + "접속 불가");
			}
			
			in = new BufferedInputStream(con.getInputStream());
			
			out = new BufferedOutputStream(new FileOutputStream(file));
			
			byte[] bytes = new byte[5];
			
			int readByte = 0;
			while((readByte = in.read(bytes)) != -1) {
				out.write(bytes, 0, readByte);
			}
			
			out.close();
			in.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(con != null)
				con.disconnect();
		}
		
	}

	public static void main(String[] args) {
		
		method2();

	}

}
