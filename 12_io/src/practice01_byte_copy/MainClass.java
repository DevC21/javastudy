package practice01_byte_copy;

public class MainClass {

  public static void main(String[] args) {
    
    MyFileUtils.fileCopy("\\Program Files\\Java\\jdk-17\\LICENSE", "\\storage\\LICENSE");
    MyFileUtils.fileMove("\\storage\\LICENSE", "\\storage\\새 폴더\\LICENSE");
  }

}