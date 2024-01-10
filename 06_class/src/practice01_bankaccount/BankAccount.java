package practice01_bankaccount;

public class BankAccount {

	// field
	private String accNo;
	private long balance;
	
	BankAccount() {
		this(null, 0);
	}
	
	BankAccount(String accNo, long balance) {
		this.accNo = accNo;
		this.balance = balance;
	}
	
	public void setaccNo(String accNo) {
		this.accNo = accNo;
	}
	
	public void setbalance(long balance) {
		this.balance = balance;
	}

	public long getbalance() {
		return this.balance;
	}
	
	public void deposit(long money) {
		if(money < 0) {
			System.out.println("입금 실패");
			return;
		}
			
		this.balance += money;
		System.out.println("입금 성공 잔액 : " + this.balance);
	}
	
	public long withdrawl(long money) {
		if(money > this.balance) {
			System.out.println("출금 실패");
			return 0;
		}
		
		this.balance -= money;
		System.out.println("출금 성공 잔액 : " + this.balance);
		return money;
	}
	
	public void transfer(BankAccount account, long money) {
		account.deposit(withdrawl(money));
	}
}
