package practice04_Bus;

public class Person {
	private String name;

	Person() {
		
	}
	
	Person(String name){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void whoami() {
		System.out.print(this.name);
	}
}
