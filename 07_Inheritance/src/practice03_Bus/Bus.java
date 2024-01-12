package practice03_Bus;

public class Bus {
	private final int Max_seats = 25;
	private Seat[] seats = new Seat[Max_seats];
	private int numOfPerson;
	
	Bus() {
		for(int i = 0; i < Max_seats; i++) 
			seats[i] = new Seat();
	}
	
	public void Enter(Person person) {
		for(int i = 0; i < Max_seats; i++) {
			if(seats[i].getPerson() == null) {
				System.out.println(person.getName() + " 이(가) " + (i + 1) + "번 좌석에 탑승했습니다.");
				seats[i].setPerson(person);
				numOfPerson++;
				break;
			}
			if(i == Max_seats - 1 && seats[i].getPerson() != null) {
				System.out.println("탑승 불가 : 버스 정원 초과");
			}
		}
	}
	
	public void Exit(int idx) {
		if(seats[idx].getPerson() != null) {
			System.out.println(seats[idx].getPerson().getName() + " 이(가) 버스에서 내립니다.");
			seats[idx].setPerson(null);
			numOfPerson--;
		}
		else {
			System.out.println("그 좌석에는 사람이 없습니다.");
		}
	}
	
	public void info() {
		System.out.println("현재 탑승 인원 : " + numOfPerson);
		System.out.println("===== 탑승자 목록 확인 =====");
		for(int i = 0; i < Max_seats; i++) {
			System.out.print((i + 1) + "번 좌석 : ");
			if(seats[i].getPerson() != null) {
				System.out.println(seats[i].getPerson().getName());
			}
			else {
				System.out.println("비어 있음");
			}
		}
	}
	
}
