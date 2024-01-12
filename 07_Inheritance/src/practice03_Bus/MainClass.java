package practice03_Bus;

public class MainClass {

	public static void main(String[] args) {
		
		Bus bus = new Bus();
		
		Man[] man = new Man[16];
		Woman[] Woman = new Woman[10];
		for(int i = 0; i < 16; i++) {
			man[i] = new Man("홍길동" + (i + 1));
		}
		for(int i = 0; i < 10; i++) {
			Woman[i] = new Woman("여길동" + (i + 1));
		}
		
		for(int i = 0; i < 16; i++) {
			bus.Enter(man[i]);
		}
		
		for(int i = 0; i < 10; i++) {
			bus.Enter(Woman[i]);
		}
		
		bus.info();
		
		for(int i = 0; i < 25; i++) {
			bus.Exit(i);
		}
		
		bus.info();
	}

}
