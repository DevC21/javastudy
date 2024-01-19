package practice01;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.UUID;

public class MainClass {

	public static void method1() {
		// 파일명 만들기
		// 형식 : 하이픈이 제거된 UUID + 밑줄 + 타임스탬프.확장자
		
		String fileName = "apple.jpg";
		
		String Extension = fileName.substring(fileName.lastIndexOf("."));
		
		String tmp = fileName.substring(0, fileName.lastIndexOf("."));
		
		long timestamp = System.currentTimeMillis();
		StringBuilder sb = new StringBuilder();
		sb.append(UUID.nameUUIDFromBytes(fileName.substring(0, fileName.lastIndexOf(".") - 1).getBytes()).toString().replace("-", ""));
		sb.append("_");
		sb.append(timestamp);
		sb.append(Extension);
		
		System.out.println(sb);
	}
	
  public static Map<String, Object> method2(String id) {
    
    // 나이 구하기 + 성별 구하기
    // 나이 : 현재년도 - 태어난년도
    // 성별 : 하이픈 뒤의 숫자가 1,3이면 남, 2,4이면 여
    String gender = "";
		int year = 0;
		
    String[] parse = id.split("-");

		LocalDateTime now = LocalDateTime.now();
		if(parse[1].charAt(0) == '1' || parse[1].charAt(0) == '2')
			year = now.getYear() - 1900 - Integer.parseInt(parse[0].substring(0, 2));
		else if(parse[1].charAt(0) == '3' || parse[1].charAt(0) == '4')
			year = now.getYear() - 2000 - Integer.parseInt(parse[0].substring(0, 2));
		
		if(parse[1].charAt(0) == '1' || parse[1].charAt(0) == '3')
			gender = "남";
		else if(parse[1].charAt(0) == '2' || parse[1].charAt(0) == '4')
			gender = "여";
		
		return Map.of("나이", year,
									"성별", gender);
  }
  
  public static void method3() {
    
    // 각 나라별 수도 맞히기
    
    // 프랑스 수도는? >>> 
    // 파리
    // 스위스 수도는? >>> 
    // 베른
    // 영국 수도는? >>> 
    // 런던
    // 독일 수도는? >>> 
    // 베를린
    // 이탈리아 수도는? >>> 
    // 로마
    // 5개 정답 성공
    Scanner sc = new Scanner(System.in);
  	
    Map<String, String> map = Map.of("프랑스", "파리"
                                   , "독일", "베를린"
                                   , "이탈리아", "로마"
                                   , "스위스", "베른"
                                   , "영국", "런던");
    
    int cnt = 0;
    
    for (String key : map.keySet()) {
      System.out.println(key + "의 수도는? >>>");
      String ans = sc.next();
      if(ans.equals(map.get(key))) {
      	System.out.println("정답");
      	cnt++;      	
      }
      else
      	System.out.println("오답");
      
    }
    System.out.println(cnt + "개 정답 성공");
    sc.close();
  }
  
  public static void method4() {

    // 5000원이 있는 통장(balance)에서 랜덤하게 출금하기
    // 실행예시)
    // 출금 전 5000원, 1회 출금액 2917원, 출금 후 2083원
    // 출금 전 2083원, 2회 출금액 1961원, 출금 후 122원
    // 출금 전 122원, 3회 출금액 102원, 출금 후 20원
    // 출금 전 20원, 4회 출금액 2원, 출금 후 18원
    // 출금 전 18원, 5회 출금액 17원, 출금 후 1원
    // 출금 전 1원, 6회 출금액 1원, 출금 후 0원
  	SecureRandom secureRandom = new SecureRandom();
  	int balance = 5000;
  	int cnt = 0;
  	
  	while(balance > 0) {
  		int withdraw = secureRandom.nextInt(balance + 1);
  		cnt++;
  		balance -= withdraw;
  		System.out.println("출금 전 " + (balance + withdraw) + "원, " + cnt + "회 출금액 " + withdraw + "원, 출금 후 " + balance + "원");
  	}
  
  }
  
  public static void method5() {

    // 윷놀이
    // 실행예시1) "도", 1칸 이동한다.
    // 실행예시2) "개", 2칸 이동한다.
    // 실행예시3) "걸", 3칸 이동한다.
    // 실행예시4) "윷", "도", 5칸 이동한다.
    // 실행예시5) "모", "윷", "도", 10칸 이동한다.
    
    String[] yuts = {"", "도", "개", "걸", "윷", "모"};
    
    StringBuilder sb = new StringBuilder();
    int move = 0;
    int tot = 0;
    
    do {
    	move = (int)(Math.random() * 5 + 1);
    	tot += move;
    	sb.append(yuts[move]);
    	sb.append(", ");

    } while(move >= 4);
    
  	System.out.println(sb.append(tot).append("칸 이동한다."));
  }

  public static void method6() {
    
    // SecureRandom을 이용해 "대문자+소문자+숫자"로 구성된 임의의 인증번호 만들기
    // 실행예시1)
    //   몇 자리의 인증번호를 생성할까요? >>> 4
    //   생성된 4자리 인증번호는 7W5e입니다.
    // 실행예시2)
    //   몇 자리의 인증번호를 생성할까요? >>> 6
    //   생성된 6자리 인증번호는 Fa013b입니다.
    SecureRandom secureRandom = new SecureRandom();
    Scanner sc = new Scanner(System.in);
    
    System.out.print("몇 자리의 인증번호를 생성할까요? >>> ");
    int n = sc.nextInt();
    StringBuilder sb = new StringBuilder();
    
    for(int i = 0; i < n; i++) {
    	double rand = secureRandom.nextDouble();
      if(rand < 0.33) {
        sb.append(secureRandom.nextInt(10));
      } else if(rand >= 0.33 && rand < 0.66){
      	sb.append((char)('a' + secureRandom.nextInt(26)));
      } else if(rand >= 0.66 && rand < 1){
      	sb.append((char)('A' + secureRandom.nextInt(26)));
      }
    }
    System.out.print("생성된 " + n +"자리 인증번호는 " + sb + "입니다.");

  }

  public static void method7() {

    // UpDown 게임
    // 컴퓨터가 1 ~ 10000 사이의 난수를 발생시킨다.
    // 사용자는 해당 난수를 맞힌다.
    // 실행예시)
    // 입력 >>> 5000
    // Down!
    // 입력 >>> 2500
    // Up!
    // ...
    // 입력 >>> 4500
    // 정답입니다. 총 5번만에 성공했습니다.
    
  	SecureRandom sr = new SecureRandom();
  	Scanner sc = new Scanner(System.in);
  	int rand = sr.nextInt(10000) + 1;
  	int input = 0;
  	int cnt = 0;
  	while(input != rand) {
  		System.out.print("입력 >>> ");
  		input = sc.nextInt();
  		cnt++;
  		if(input > rand)
  			System.out.println("Down!");
  		else if(input < rand)
  			System.out.println("Up!");
  		else {
  			System.out.println("정답입니다. 총 " + cnt + "번만에 성공했습니다.");
  		}
  	}
    
  }

  public static void method8() {

    // 0~9 사이 난수를 100개 발생시키고 발생한 난수들이 생성된 횟수(빈도수)를 그래프화 하여 출력하시오.
    // 실행예시)
    // 0 : #### 4
    // 1 : ############ 12
    // 2 : ############ 12
    // 3 : ##### 5
    // 4 : ######## 8
    // 5 : ########### 11
    // 6 : ############ 12
    // 7 : ################## 18
    // 8 : ####### 7
    // 9 : ########### 11
    
  	SecureRandom sr = new SecureRandom();
  	int[] cnt = new int[10];
    for(int i = 0; i < 100; i++) {
    	cnt[sr.nextInt(10)]++;
    }
    
    for(int i = 0; i < 10; i++) {
    	System.out.print(i + " : ");
    	for(int j = 0; j < cnt[i]; j++) {
    		System.out.print("#");
    	}
    	System.out.println(" " + cnt[i]);
    }
  }
  
  public static void method9() {
    
    // 5 x 5 숫자 빙고판 자동 생성
    //
    // 지시사항)
    //   1. 1 ~ 25 사이 정수를 2차원 배열 bingo 에 순차적으로 넣는다.
    //      1  2  3  4  5
    //      6  7  8  9 10
    //     11 12 13 14 15
    //     16 17 18 19 20
    //     21 22 23 24 25
    //   2. 25번 서로 섞는다.
    //      순차적으로        랜덤하게
    //      모든요소접근      접근
    //      ----------------------------
    //      bingo[0][0]  <->  bingo[1][4]
    //      bingo[0][1]  <->  bingo[0][2]
    //      bingo[0][2]  <->  bingo[2][1]
    //      ...
    //      bingo[4][4]  <->  bingo[3][1]
    //
    // 실행예시)
    //  10  9  4 25  2
    //  15  3 13 21  1
    //  14 20 11 19  6
    //   8 17  5 12  7
    //  16 22 18 24 23
  	
  	SecureRandom sr = new SecureRandom();
  	int[][] bingo = new int[5][5];
  	
  	int cnt = 1;
  	for(int i = 0 ; i < 5; i++) {
  		for(int j = 0; j < 5; j++) {
  			bingo[i][j] = cnt;
    		cnt++;
  		}
  	}
  	for(int i = 0 ; i < 5; i++) {
  		for(int j = 0; j < 5; j++) {
  			System.out.print(bingo[i][j] + " ");
  		}
  		System.out.println();
  	}
  	
  	for(int i = 0 ; i < 5; i++) {
  		for(int j = 0; j < 5; j++) {
  			int x = sr.nextInt(5);
  			int y = sr.nextInt(5);
  			int tmp = bingo[x][y]; 
  			bingo[x][y] = bingo[i][j];
  			bingo[i][j] = tmp;
  		}
  	}
  	
  	for(int i = 0 ; i < 5; i++) {
  		for(int j = 0; j < 5; j++) {
  			System.out.print(bingo[i][j] + " ");
  		}
  		System.out.println();
  	}
    
  }
  
  
  public static void main(String[] args) {
//  	method1();
//    Map<String, Object> map = method2("140101-3123456");
//    
//    // map을 for문으로 돌려서 확인하기
//    Set<Entry<String, Object>> entrySet = map.entrySet();
//    for(Entry<String, Object> entry : entrySet) {
//      System.out.println(entry.getKey() + " : " + entry.getValue());
//    }
  
    method5();
  }
}
