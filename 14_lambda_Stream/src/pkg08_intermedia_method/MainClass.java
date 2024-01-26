package pkg08_intermedia_method;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainClass {

	public static void method1() {
		
		// filter() 메소드
		// Stream<T> filter(Predicate<T> predicate) { }
		
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//		Stream<Integer> numbers = list.stream();
		
		list.stream().filter(number -> number % 2 == 0).forEach(number -> System.out.println(number));
	}

	public static void method2() {
		List<Book> books = Arrays.asList(
							new Book("어린왕자", "생 텍쥐 베리", 5000), 
							new Book("홍길동전", "미상", 10000), 
							new Book("일론 머스크", "일론 머스크", 15000)
						);
		
		books.stream()
								.filter(book -> book.getPrice() >= 10000)
								.forEach(book -> System.out.println(book.getTitle()));
		
		List<Book> over10000 = books.stream()
            		.filter(book -> book.getPrice() >= 10000)
            		.collect(Collectors.toList());
		
		System.out.println(over10000);
	}
	
	public static void method3() {
		
		// map() 메소드 : 값을 바꿀 때 사용
		// Stream<T> map<Function<T, R> function) { }
		
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		
		list.stream()
//			.filter(number -> number % 2 == 0)
			.map(number -> number + 1)
			.forEach(number -> System.out.println(number));
	}
	
	public static void method4() {
		
		// 10000원 이상의 책 가격을 50% 세일한 리스트 생성하기
		
		List<Book> books = Arrays.asList(
				new Book("어린왕자", "생 텍쥐 베리", 5000), 
				new Book("홍길동전", "미상", 10000), 
				new Book("일론 머스크", "일론 머스크", 15000)
			);

		List<Book> saleBooks = books.stream()
    					.filter(book -> book.getPrice() >= 10000)
    					.map(book -> new Book(book.getTitle(), book.getTitle(), book.getPrice() / 2))
    					.collect(Collectors.toList());
		
		saleBooks.stream().forEach(book -> System.out.println(book.getTitle() + " " + book.getPrice()));
	}
	
	public static void main(String[] args) {
		method4();
	}

}
