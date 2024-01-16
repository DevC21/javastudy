package practice01_bankaccount;

public class MainClass {

	public static void main(String[] args) {
		
		// 생성자
		BankAccount account1 = new BankAccount();
		
		// Setter
		account1.setaccNo("01098765432");
		account1.setbalance(100_000);
		
		// 생성자
		BankAccount account2 = new BankAccount("01012345789", 50000);
		
		/////////
		try {
			account1.deposit(100_000); // 10만원 입금 (성공)
			account1.deposit(-50_000); // -5만원 입금 (실패)
		}
		catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}

		
		long money = 0;
		try {
			money = account1.withdrawl(100_000); // 10만원 출금 (성공)
			System.out.println("출금된 금액 : " + money); // 100000 (출금된 금액 출력)
			money = account1.withdrawl(200_000); // 20만원 출금 (실패)
			System.out.println("출금된 금액 : " + money); // 0 (출금된 금액 출력)
		}
		catch (RuntimeException e){
			System.out.println(e.getMessage());
		}

		
		/////////
		
		try {
			account1.transfer(account2, 50000); // acount1 -> account2, 50000원 이체 (성공)
			System.out.println("account2의 잔액 : " + account2.getbalance());
			account1.transfer(account2, 100000); // acount1 -> account2, 100000원 이체 (실패)
			System.out.println("account2의 잔액 : " + account2.getbalance());
		}
		catch (RuntimeException e){
			System.out.println(e.getMessage());
		}

	}

}
