 package pkg05_Function;

import java.util.function.Function;

public class MainClass {

	/*
	 * java.util.funcion.Function
	 * 
	 * 1. 형식
	 * 	public interface Function<T, R> {
	 * 		R apply(T t);
	 * 	}
	 * 2. 파라미터 O, 반환 O 형식의 apply() 메소드를 지원하는 함수형 인터페이스이다.
	 */
	
	public static void method1() {
		Function<String, Integer> f = s -> Integer.parseInt(s);
		System.out.println(f.apply("100"));
	}
	
	public static void method2(Function<String, Integer> f, String s) {
		System.out.println(f.apply(s));
	}
	
	public static void main(String[] args) {
//		method1();
		
//		method2(s -> Integer.parseInt(s), "100");
		method2(Integer::parseInt, "100");
		
	}

}
