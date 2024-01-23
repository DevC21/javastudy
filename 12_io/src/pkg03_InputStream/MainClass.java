package pkg03_InputStream;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainClass {
	
	/*
	 *  java.io.FileInputStream
	 *  1. 바이트 기반의 파일 입력 스트림이다.
	 *  2. 입력 단위
	 *  	 1) int
	 *  	 2) byte[]
	 */
	
	public static void method1() {
		
		File dir = new File("\\storage");
		File file = new File(dir, "sample1.dat");
		
		// 파일 입력 스트림 선언
		FileInputStream in = null;
				
		try {
			
			// 파일 입력 스트림 생성
			in = new FileInputStream(file); // FileNotFoundException 예외 발생
			
			// 읽은 데이터를 보관할 배열
			byte[] b = new byte[(int) file.length()];
			
			// 읽을 단위 (int 변수로 1바이트씩 읽는다.)
			int c = 0;
			
			// 읽기
			int idx = 0;
			while(true) {
				c = in.read();
				if(c == -1)
					break;
				b[idx] = (byte)c;
				idx++;
			}
			
			System.out.print(new String(b));
			
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("파일의 경로를 확인하세요.");
		} catch (IOException e) {
			System.out.println("입출력 예외가 발생했습니다.");
		}
	}

	public static void method2() {
		
		File dir = new File("\\storage");
		File file = new File(dir, "sample2.dat");
		
		// 파일 입력 스트림 선언
		FileInputStream in = null;
				
		try {
			// 파일 입력 스트림 생성
			in = new FileInputStream(file);
			
			// 읽은 데이터를 보관할 배열
			byte[] b = new byte[(int)file.length()];
			
			// 읽을 단위 (byte[] 배열로 읽는다.)
			byte[] bytes = new byte[5];
			
			// 읽기
			int idx = 0;
			while(true) {
				int readByte = in.read(bytes);
				if(readByte == -1)
					break;
				System.arraycopy(bytes, 0, b, idx, readByte);
				idx += readByte;
			}
			
			System.out.println(new String(b));
			
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("파일의 경로를 확인하세요.");
		} catch (IOException e) {
			System.out.println("입출력 예외가 발생했습니다.");
		}
		
	}
	
	public static void method3() {
		
		File dir = new File("\\storage");
		File file = new File(dir, "sample3.dat");
		
		// 버퍼 입력 스트림 선언
		BufferedInputStream in = null;
				
		try {
			// 파일 입력 스트림 생성
			in = new BufferedInputStream(new FileInputStream(file));
			
			// 읽은 데이터를 보관할 배열
			byte[] b = new byte[(int)file.length()];
			
			// 읽을 단위 (byte[] 배열로 읽는다.)
			byte[] bytes = new byte[5];
			
			// 읽기
			int idx = 0;
			int readByte = 0;
//			while(true) {
//				readByte = in.read(bytes);
//				if(readByte == -1)
//					break;
//				System.arraycopy(bytes, 0, b, idx, readByte);
//				idx += bytes.length; 
//			}
			
			while( (readByte = in.read(bytes)) != -1) {
				System.arraycopy(bytes, 0, b, idx, readByte);
				idx += bytes.length; // idx += readByte;
			}
			
			
			System.out.println(new String(b));
			
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("파일의 경로를 확인하세요.");
		} catch (IOException e) {
			System.out.println("입출력 예외가 발생했습니다.");
		}
	}
	
	public static void main(String[] args) {
		method3();
	}

}
