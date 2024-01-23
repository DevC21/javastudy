package practice01_byte_copy;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MyFileUtils {

	// 파일 복사 메소드
	public static void fileCopy(String src, String dest) {
		File source = new File(src);
		File output = new File(dest);
		
		BufferedInputStream in = null;
		BufferedOutputStream out = null;
		
		try {			
			in = new BufferedInputStream(new FileInputStream(source));
			out = new BufferedOutputStream(new FileOutputStream(output));
			
			byte[] bytes = new byte[5];
			int readbyte = 0;
			
			while((readbyte = in.read(bytes)) != -1) {
				out.write(bytes, 0, readbyte);
			}
			
			out.close();
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// 파일 이동 메소드
	public static void fileMove(String src, String dest) {
		File source = new File(src);
		File output = new File(dest);
		
		BufferedInputStream in = null;
		BufferedOutputStream out = null;
		
		try {			
			in = new BufferedInputStream(new FileInputStream(source));
			out = new BufferedOutputStream(new FileOutputStream(output));
			
			byte[] bytes = new byte[5];
			int readbyte = 0;
			
			while((readbyte = in.read(bytes)) != -1) {
				out.write(bytes, 0, readbyte);
			}
			
			out.close();
			in.close();
			source.delete();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
