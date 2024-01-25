package pkg02_open_api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainClass {

	public static void main(String[] args) {
			
		StringBuilder api = new StringBuilder();
		api.append("http://apis.data.go.kr/B552061/AccidentDeath/getRestTrafficAccidentDeath");
		api.append("?serviceKey=").append("hDF6TSJkpcmj%2BhaglyALGEsMyPvND%2BDCjtn%2BLEXpDhjN822tg2vzhwNi%2BWU8dV85L0vrBFHbSXuTKyIJycQsFg%3D%3D");
		api.append("&searchYear=").append(2022);
		api.append("&siDo=").append(1100);
		api.append("&guGun=").append(1125);
		api.append("&type=").append("json");
		api.append("&numOfRows=").append(10);
		api.append("&pageNo=").append(1);

		String spec = api.toString();
		
		URL url = null;
		HttpURLConnection con = null;
		
		BufferedReader in = null;
		
		try {
			
			url = new URL(spec);
			con = (HttpURLConnection)url.openConnection();
			
			if(con.getResponseCode() != HttpURLConnection.HTTP_OK) {
				throw new RuntimeException("API 요청 실패");
			}
			
			in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			
			
			
			StringBuilder sb = new StringBuilder();
			String line = null;
			
			while((line = in.readLine()) != null) {
				sb.append(line);
			}
			
			System.out.println(sb.toString());
			
			in.close();
			con.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

}
