package practice04_Bus;

import java.util.ArrayList;
import java.util.List;

public class Bus {
	public final int Max_seats = 25;
	private List<Seat> seats = new ArrayList<Seat>(Max_seats);
	private int numOfPerson;
	
	Bus() {
		for(int i = 0; i < Max_seats; i++) {
			seats.add(new Seat());
		}
	}
	
	public void Enter(Person person) {
		for(int i = 0; i < Max_seats; i++) {
			if(seats.get(i).getPerson() == null) {
				System.out.println(person.getName() + " 이(가) " + (i + 1) + "번 좌석에 탑승했습니다.");
				seats.get(i).setPerson(person);
				numOfPerson++;
				break;
			}
			if(i == Max_seats - 1 && seats.get(i).getPerson() != null) {
				throw new RuntimeException("탑승 불가 : 버스 정원 초과");
			}
		}
	}
	
	// idx : 1 ~ Max_seats
	public void Exit(int idx) {
		if(seats.get(idx - 1).getPerson() != null) {
			System.out.println(seats.get(idx - 1).getPerson().getName() + " 이(가) 버스에서 내립니다.");
			seats.get(idx - 1).setPerson(null);
			numOfPerson--;
		}
		else {
			throw new RuntimeException(idx + "번 좌석에는 사람이 없습니다.");
		}
	}
	
	public void info() {
		System.out.println("현재 탑승 인원 : " + numOfPerson);
		System.out.println("===== 탑승자 목록 확인 =====");
		for(int i = 0; i < Max_seats; i++) {
			System.out.print((i + 1) + "번 좌석 : ");
			if(seats.get(i).getPerson() != null) {
				System.out.println(seats.get(i).getPerson().getName());
			}
			else {
				System.out.println("비어 있음");
			}
		}
	}
	
}
