package pkg02_FunctionalInterface;

public class MainClass {

	public static void main(String[] args) {
		// interface MyInterface1 { void method(); }
		MyInterface1 my1 = () -> System.out.println("hello world ");
		my1.method();
		
		// interface MyInterface2 { String method(); }
		MyInterface2 my2 = () -> "hello world";
		System.out.println(my2.method());
		
		// interface MyInterface3 { void method(String s); }
		MyInterface3 my3 = (s) -> System.out.println(s + "님");
		my3.method("TEST");
		
		// interface MyInterface4 { String method(String s); }
		MyInterface4 my4 = (s) -> s + "님";
		System.out.println(my4.method("TEST"));
	}

}
