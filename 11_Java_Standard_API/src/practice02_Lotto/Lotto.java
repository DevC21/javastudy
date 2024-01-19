package practice02_Lotto;

import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Lotto {
  
  /**
   * 로또 구매<br>
   * 로또 구매를 위해서 사용자로부터 money를 입력 받는 메소드<br>
   * 로또 구매 비용은 최소 1000, 최대 100000이다.<br>
   * @return money   사용자가 입력한 로또 구매 비용에서 1000 미만 단위는 버리고 반환. ex) 5999 입력 시 5000 반환
   * @return 0       로또 구매 실패 시 반환
   */
  public int buyLotto() throws RuntimeException {
    
    Scanner sc = new Scanner(System.in);
    
    int money = sc.nextInt() / 1000 * 1000;
    
    if(money < 1000 || money > 100_000)
    	money = 0;
    	
    return money;
  }
  
  /**
   * 로또 번호 생성<br>
   * 로또 구매 비용만큼 로또 번호를 생성하는 메소드<br>
   * 5게임씩 끊어서 생성된 로또 번호를 출력한다.<br>
   * @param money   로또 구매 비용
   */
  public List<String> generateLotto(int money) {
    
    /*
     * 예시) 5000원 구매
     * 
     * 01 : 1  2  3  4  5  6
     * 02 : 1  2  3  4  5  6
     * 03 : 1  2  3  4  5  6
     * 04 : 1  2  3  4  5  6
     * 05 : 1  2  3  4  5  6
     */
    /*
     * 예시) 10000원 구매
     * 
     * 01 : 1  2  3  4  5  6
     * 02 : 1  2  3  4  5  6
     * 03 : 1  2  3  4  5  6
     * 04 : 1  2  3  4  5  6
     * 05 : 1  2  3  4  5  6
     * 
     * 01 : 1  2  3  4  5  6
     * 02 : 1  2  3  4  5  6
     * 03 : 1  2  3  4  5  6
     * 04 : 1  2  3  4  5  6
     * 05 : 1  2  3  4  5  6
     */
    
    List<String> papers = new ArrayList<String>();
    
    SecureRandom sr = new SecureRandom();
   
    int i = 1;
    while(money > 0) {
  		DecimalFormat df = new DecimalFormat("00");
    	StringBuilder sb = new StringBuilder();
    	sb.append(df.format(i)).append(" : ");
    	Set<Integer> paper = new HashSet<Integer>();
    	while(paper.size() < 7) {
    		paper.add(sr.nextInt(45) + 1);
    	}
    	Integer[] list = paper.toArray(new Integer[0]);
    	Arrays.sort(list);
    	
    	for(int num : list) {
    		sb.append(num).append(" ");
    	}
    	papers.add(sb.toString());
    	money -= 1000;
    	i++;
    	if(i > 5) {
    		papers.add("");
    		i = 1;
    	}
    }
       
    return papers;
    
  }
  
}