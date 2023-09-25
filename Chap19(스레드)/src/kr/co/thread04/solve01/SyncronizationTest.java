package kr.co.thread04.solve01;

class Bank {
	private int money = 10000;

	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
	// 예금
	public void deposit(int save) {
		synchronized (this) {							// synchronized 블록
			int m = this.getMoney();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			setMoney(m + save);
		}
	}
	
	// 인출
	public synchronized void withdraw(int minus) {		// synchronized 메서드
		int m = this.getMoney();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		setMoney(m - minus);
	}
}

class Lee extends Thread {
	@Override
	public void run() {
		System.out.println("Lee 입급 시작");
		SyncronizationTest.myBank.deposit(3000);
		System.out.println("Lee 3000원 입금 : " + SyncronizationTest.myBank.getMoney());
	}
}

class Shin extends Thread {
	@Override
	public void run() {
		System.out.println("Shin 출금 시작");
		SyncronizationTest.myBank.withdraw(1000);
		System.out.println("Shin 1000원 출금 : " + SyncronizationTest.myBank.getMoney());
	}
}

public class SyncronizationTest {

	public static Bank myBank = new Bank();
	
	public static void main(String[] args) {
		
		Lee threadLee = new Lee();
		threadLee.start();

		Shin threadShin = new Shin();
		threadShin.start();
		/*
			Lee 입급 시작
			Shin 출금 시작
			Lee 3000원 입금 : 13000
			Shin 1000원 출금 : 12000
		 */
	}
}
