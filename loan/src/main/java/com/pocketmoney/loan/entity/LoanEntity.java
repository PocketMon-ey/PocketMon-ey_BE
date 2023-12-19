package com.pocketmoney.loan.entity;


import java.util.Date;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class LoanEntity {
	public LoanEntity(int id, String reason, int price, int totalPrice, int remainPrice, Double interestRate,
			int monthlyRepaymentPrice, int period, String startDate, String endDate, int repaymentCnt, int status,
			String rejectReason, Date createDate, Date updateDate, int childId) {
		super();
		this.id = id;
		this.reason = reason;
		this.price = price;
		this.totalPrice = totalPrice;
		this.remainPrice = remainPrice;
		this.interestRate = interestRate;
		this.monthlyRepaymentPrice = monthlyRepaymentPrice;
		this.period = period;
		this.startDate = startDate;
		this.endDate = endDate;
		this.repaymentCnt = repaymentCnt;
		this.status = status;
		this.rejectReason = rejectReason;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.childId = childId;
	}
	int id;
	String reason; // 대출 사유 
	int price; // 총 대출 금액 
	int totalPrice; // 갚을 금액 
	int remainPrice;
	Double interestRate;
	int monthlyRepaymentPrice;
	int period;
	String startDate;
	String endDate;
	int repaymentCnt;
	int status;
	String rejectReason;
	Date createDate;
	Date updateDate;
	int childId;
	
	
}
