package pkg06_Predicate;

import java.util.function.Predicate;

public class MainClass {

	/*
	 * java.util.function.Predicate
	 * 
	 * 1. 형식
	 * 	public interface Predicate<T> {
	 * 		R test(T t);
	 * 	}
	 * 
	 * 2. 파라미터 O, 반환 boolean 형식의 test() 메소드를 지원하는 함수형 인터페이스이다.
	 */
	
	public static void method1() {
		Predicate<Integer> p = i -> i % 2 == 0;
		if(p.test(5))
			System.out.println("짝수");
		else
			System.out.println("홀수");
	}
	
	public static void method2(Predicate<Integer> p, int i) {
		if(p.test(i))
			System.out.println("짝수");
		else
			System.out.println("홀수");
	}
	
	public static void main(String[] args) {
		method1();
		method2(i -> i % 2 == 0, 10);
	}

}
