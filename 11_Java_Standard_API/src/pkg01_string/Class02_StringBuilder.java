package pkg01_string;

public class Class02_StringBuilder {

	/*
	 * 							StringBuffer			StringBuilder
	 * 	since 			JDK 1.0						JDK 1.5
	 * 	THREAD-SAFE	Multi Thread			Single Thread
	 * 	speed				slow							fast
	 */
	
	public static void main(String[] args) {
		
		// StringBuilder 객체 생성
		StringBuilder sb = new StringBuilder();
		
		// 문자열 추가하기
		sb.append("바");
		sb.append("나");
		sb.append("나");
		
		// String 객체로 바꾸기
		// 1. new String(sb)
		// 2. sb.toString()
		
		String s = sb.toString();
		System.out.println(s);
	}
}
