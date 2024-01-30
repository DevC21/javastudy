package practice01_dml;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class MainClass {

	/*
	 * TALK_T 테이블에 1행씩 삽입하시오
	 * TALK_T 구조
	 * 		TALK_NO	NUMBER (PK)
	 * 		TALK_CONTENT VARCHAR2(1000 BYTE)
	 * 		TALK_USER VARCHAR2(1000 BYTE)
	 * 		WRITEN_AT TIMESTAMP (* 현재 날짜/시간 : CURRENT_TIMESTAMP)
	 * DB 서버 환경
	 * 		192.168.0.214
	 * 		GD/1111
	 * 
	 */
	
	public static void method1() {
		Connection con = null;
		PreparedStatement ps = null;                                                                  
		
		try {
			
			Class.forName("oracle.jdbc.OracleDriver");
			
			String url = System.getProperty("jdbc.url");
			String user = System.getProperty("jdbc.user");
			String password = System.getProperty("jdbc.password");
			con = DriverManager.getConnection(url, user, password);
			
			String sql = "UPDATE TALK_T "
					+ "SET TALK_CONTENT = ?"
					+ ", WRITEN_AT = CURRENT_TIMESTAMP "
					+ "WHERE TALK_USER = ?";
			
//			String sql = "INSERT INTO TALK_T(TALK_NO, TALK_CONTENT, TALK_USER, WRITEN_AT) "
//					+ "VALUES(TALK_SEQ.NEXTVAL, ?, ?, CURRENT_TIMESTAMP)";
			
			ps = con.prepareStatement(sql);
			
			// 변수 입력 받기
			Scanner sc = new Scanner(System.in);
			System.out.println("내용 입력하세요 >>> ");
			String content = sc.next();
			
			System.out.println("편집자 입력하세요 >>> ");
			String editor = sc.next();
		
			sc.close();
			
			// 변수를 쿼리문에 전달하기
			ps.setString(1, content); // 쿼리문의 1번째 물음표에 String content 전달하기
			ps.setString(2, editor); // 쿼리문의 2번째 물음표에 String editor 전달하기
			
			int result = ps.executeUpdate();
			
			System.out.println(result + " 행 이(가) 삽입되었습니다.");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null) ps.close();
				if(con != null) con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		method1();
	}

}
