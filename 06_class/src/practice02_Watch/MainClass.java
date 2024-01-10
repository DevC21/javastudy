package practice02_Watch;

public class MainClass {

	public static void main(String[] args) {
		Watch watch = new Watch(9, 0, 0); // 09:00:00
				
		watch.addHour(3); // 12:00:0
		watch.addMinute(80); // 13:20:0
		watch.addSecond(3650); // 14:20:50
		
		watch.see(); // 14:20:50
	}

}
