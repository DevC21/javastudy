package practice03_Bus;

public class Seat {
	private Person person;
	
	Seat(){
		
	}
	
	Seat(Person person){
		this.person = person;
	}
	
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
}
