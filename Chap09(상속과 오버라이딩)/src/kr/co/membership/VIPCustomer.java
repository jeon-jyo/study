package kr.co.membership;
/*
 * * 우수고객
 *  - 물품 구매시 5% 보너스 포인트 적립
 * 	- 물품 구매시 10% 할인
 *  - 담당 전문 직원 배정
 */
public class VIPCustomer extends Customer {

	private int agentId;
	double salesRatio;
	
	public VIPCustomer() {
		// super();
		this.setCustomerGrade("VIP");
		this.bonusRatio = 0.05;
		this.salesRatio = 0.1;
		System.out.println("VIPCustomer() 생성자 호출");
	}
	
	public VIPCustomer(int customerId, String customerName) {
		super(customerId, customerName);
		this.setCustomerGrade("VIP");
		this.bonusRatio = 0.05;
		this.salesRatio = 0.1;
		System.out.println("VIPCustomer(int, String) 생성자 호출");
	}

	public int getAgentId() {
		return agentId;
	}
	
	// 정의부는 똑같고 구현부만 차이
	// 자식에서 @Override 했으면 자식 것을 호출
	@Override
	public int clacPrice(int price) {
		bonusPoint += price * bonusRatio;
		System.out.println("clacPrice(int) : ["
				+ price + " 원 지불, " + (int)(price * this.bonusRatio) + " 포인트 적립, "
				+ (int)(price * salesRatio) + " 원 할인, 총 " + (price - (int)(price * salesRatio)) + " 원 지불]");
		return price - (int)(price * salesRatio);
	}
	
}
