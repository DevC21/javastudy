package practice02_Watch;

public class Watch {
	private int Hour;
	private int Minute;
	private int Second;
	
	Watch(int Hour, int Minute, int Second){
		super();
		this.Hour = Hour;
		this.Minute = Minute;
		this.Second = Second;
	}
	
	public void addHour(int Hour) {
		if(Hour <= 0) {
			return;
		}
		this.Hour += Hour;
		this.Hour %= 24;
	}
	
	public void addMinute(int Minute) {
		if(Minute <= 0) {
			return;
		}
		this.Minute += Minute;
		addHour(this.Minute / 60);
		this.Minute %= 60;
	}
	
	public void addSecond(int Second) {
		if(Second <= 0) {
			return;
		}
		this.Second += Second;
		addMinute(this.Second / 60);
		this.Second %= 60;
	}
	
	public void see() {
		System.out.println(this.Hour + ":" + this.Minute + ":" + this.Second);
	}
}
