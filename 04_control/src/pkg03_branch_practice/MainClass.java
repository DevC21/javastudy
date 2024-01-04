package pkg03_branch_practice;

public class MainClass {

  public static void method1(int month) {
    
    // 월에 따른 계절 출력하기
    
    if(month >= 1 && month <= 3) System.out.println("겨울");
    else if(month > 3 && month <= 6) System.out.println("봄");
    else if(month > 6 && month <= 9) System.out.println("여름");
    else if(month > 9 && month <= 12) System.out.println("가을");
  }
  
  public static void method2(int score, int grade) {
    
    // 점수와 학년에 따른 합격 여부
    // 1~3학년 : 60점 이상이면 합격, 아니면 불합격
    // 4~6학년 : 70점 이상이면 합격, 아니면 불합격
    
    if(grade >= 1 && grade <= 3) {
    	if(score >= 60)
    			System.out.println("합격");
    	else
    		System.out.println("불합격");
    }
    else if(grade > 3 && grade <= 6){
    	if(score >= 70)
  			System.out.println("합격");
    	else
    		System.out.println("불합격");
    }
  }
  
  public static void method3(int day, int nDay) {
    
    // 2024년 1월 4일은 목요일, n일 후는 무슨 요일?
    String[] weekName = {"월", "화", "수", "목", "금", "토", "일"};  // 요일 (월~일)
    
    System.out.println(weekName[(day - 1 + nDay) % 7] + "요일");
  }
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub
  	method1(1);
  	method2(60, 1);
  	method3(4, 10);
  }

}