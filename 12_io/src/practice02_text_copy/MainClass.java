package practice02_text_copy;

import java.io.File;

public class MainClass {

	public static void main(String[] args) {
		
		MyFileUtils.fileCopy(new File("\\storage\\sample2.txt"), new File("\\storage\\새 폴더\\sample2.txt"));
		MyFileUtils.fileMove(new File("\\storage\\sample2.txt"), new File("\\storage\\새 폴더\\sample2.txt"));
	}

}
