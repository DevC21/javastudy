package practice02_dql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainClass {

  /*
   * TALK_T 테이블의 데이터를 TALK_NO의 내림차순으로 정렬한 뒤 11 ~ 20번째 행을 조회하여 List에 저장하시오
   * 
   * TALK_T 구조
   *    TALK_NO      NUMBER (PK)
   *    TALK_CONTENT VARCHAR2(1000 BYTE)
   *    TALK_USER    VARCHAR2(1000 BYTE)
   *    WRITTEN_AT    TIMESTAMP (* 현재 날짜/시간 : CURRENT_TIMESTAMP)
   * TALK_SEQ 시퀀스 존재함
   * DB 서버 환경
   *    192.168.0.214
   *    GD/1111
   */
	
	public static void method1() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			Class.forName("oracle.jdbc.OracleDriver");
			
			String url = System.getProperty("jdbc.url");
			String user = System.getProperty("jdbc.user");
			String password = System.getProperty("jdbc.password");
			
			con = DriverManager.getConnection(url, user, password);
			
			String sql = "SELECT TALK_NO, TALK_CONTENT, TALK_USER, WRITTEN_AT "
					+ "FROM ((SELECT ROW_NUMBER() OVER(ORDER BY TALK_NO DESC) AS RN, TALK_NO, TALK_CONTENT, TALK_USER, WRITTEN_AT FROM TALK_T)) "
					+ "WHERE RN BETWEEN ? AND ?";
			
			ps = con.prepareStatement(sql);
			
			Scanner sc = new Scanner(System.in);
			System.out.println("시작 rNum 입력하세요 >>> ");
			int start = sc.nextInt();
			System.out.println("끝 rNum 입력하세요 >>> ");
			int end = sc.nextInt();
			sc.close();
			
			ps.setInt(1, start);
			ps.setInt(2, end);
			
			rs = ps.executeQuery();
			
			List<TalkDto> list = new ArrayList<TalkDto>();
			// 결과 조회
			while(rs.next()) {
				
				// 결과 행을 SampleDto 객체를 만든다.
				TalkDto talkdto = new TalkDto();
				talkdto.setTALK_NO(rs.getInt(1));
				talkdto.setTALK_CONTENT(rs.getString(2));
				talkdto.setTALK_USER(rs.getString(3));
				talkdto.setWRITTEN_AT(rs.getTimestamp(4));
				list.add(talkdto);
			}
			
			for(int i = 0, size = list.size(); i < size; i++) {
				System.out.println(list.get(i));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(ps != null)	ps.close();
				if(con != null)	con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		method1();
	}

}
