package pkg07_terminal_method;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

public class MainClass {

	public static void method1() {
		
		// java.util.stream.Stream 생성
		Stream<String> seasons = Stream.of("봄", "여름", "가을", "겨울");

		// forEach() 메소드 호출
		// Stream 에 저장된 요소를 Consumer 의 파라미터에 전달하는 메소드
		seasons.forEach(s -> System.out.println(s));
		
	}
	
	public static void method2() {
		
		// 배열을 Stream 으로 만들기
		String[] seasons = {"봄", "여름", "가을", "겨울"};
		Stream<String> stream = Arrays.stream(seasons);
		
		// forEach() 메소드 호출
		stream.forEach(s -> System.out.println(s));
	
	}
	
	public static void method3() {
		
    // Collection(List, Set) 을 Stream 으로 만들기
		
		List<String> seasons = Arrays.asList("봄", "여름", "가을", "겨울");
		Stream<String> stream = seasons.stream();
		stream.forEach(s -> System.out.println(s));
		
    new HashSet<String>(seasons).stream()
    .forEach((season) -> System.out.println(season));
    
	}
	
	public static void method4() {
		File dir = new File("\\storage");
		File file = new File(dir, "sample2.txt");
		
		BufferedReader in = null;
		
		try {
			in = new BufferedReader(new FileReader(file));
			
			StringBuilder sb = new StringBuilder();
			
			in.lines().forEach(s -> sb.append(s).append('\n'));
			
			in.close();
			
			System.out.println(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void method5() throws Exception{
		// JAVA_HOME 파일명 출력하기
		
		File javahome = new File("\\Program Files\\Java\\jdk-17");

		Stream<File> files = Arrays.stream(javahome.listFiles());
		
		files.forEach(f -> System.out.println(f.getName()));
		
		Path path = Paths.get("\\Program Files\\Java\\jdk-17");
		Stream<Path> files2 =  Files.list(path);
		files2.forEach(p -> System.out.println(p.getFileName()));
		files2.close();
	}

	
	public static void main(String[] args) throws Exception {
		method5();
	}

}
