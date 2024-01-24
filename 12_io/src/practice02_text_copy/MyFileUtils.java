package practice02_text_copy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyFileUtils {

	public static void fileCopy(File src, File dest) {
		
		BufferedReader in = null;
		BufferedWriter out = null;
		
		try {
			in = new BufferedReader(new FileReader(src));
//	  	in = new BufferedReader(new InputStreamReader(new FileInputStream(src)));
			out = new BufferedWriter(new FileWriter(dest));
			
			String line = null;

			while((line = in.readLine()) != null) {
				out.write(line);
				out.newLine();
			}
			
			out.close();
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void fileMove(File src, File dest) {
		fileCopy(src, dest);
		src.delete();
	}
}
