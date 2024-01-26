package pkg04_Consumer;

import java.util.function.Consumer;

public class MainClass {
	
	/*
	 * java.uitl.function.Consumer
	 * 
	 * 1. 형식
	 * 	public interface Consumer<T> {
	 * 		void accept(T t);
	 * 	}
	 * 2. 파라미터 O, 반환 X 형식의 accept() 메소드를 지원하는 함수형 인터페이스이다.
	 */
	
	public static void method1() {
		Consumer<String> consumer = s -> System.out.println(s);
		consumer.accept("TEST");
	}
	
	public static void method2(Consumer<String> consumer, String s) {
		consumer.accept(s);
	}

	public static void main(String[] args) {
		method1();
		method2(s -> System.out.println(s), "TEST");
	}

}
