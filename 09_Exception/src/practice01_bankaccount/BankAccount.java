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
	
	// 1. 메소드마다 try - catch 넣기
	// 2. 메소드 호출한 곳으로 예외 던지기
	
	public void deposit(long money) throws RuntimeException {
		if(money < 0) {
			throw new RuntimeException("입금 실패");
		}
			
		this.balance += money;
		System.out.println("입금 성공 잔액 : " + this.balance);
	}
	
	public long withdrawl(long money) throws RuntimeException {
		if(money > this.balance) {
			throw new RuntimeException("출금 실패");
		}
		
		this.balance -= money;
		System.out.println("출금 성공 잔액 : " + this.balance);
		return money;
	}
	
	public void transfer(BankAccount account, long money) throws RuntimeException{
		try {
			account.deposit(withdrawl(money));
		}
		catch (RuntimeException e) {
			throw new RuntimeException("이체 실패");
		}
	}
}
