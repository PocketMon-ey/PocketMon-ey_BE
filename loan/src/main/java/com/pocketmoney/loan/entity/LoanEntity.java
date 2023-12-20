package com.pocketmoney.loan.entity;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoanEntity {
	public LoanEntity(
			int id,
			String reason,
			int price, 
			int totalPrice,
			int remainPrice,
			Double interestRate,
			int monthlyRepaymentPrice,
			int period,
			String startDate,
			String endDate,
			int repaymentCnt,
			int status,
			String rejectReason,
			Date createDate,
			Date updateDate,
			int childId
			) {
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
	int totalPrice; // 총 납입 금액 
	int remainPrice; // 남은 금액 
	double interestRate;
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
	
	public Boolean repay() {
		this.repaymentCnt += 1;
		if(this.repaymentCnt == period) {
			this.remainPrice = 0;
			this.status = 2;
			return true;
		}
		this.totalPrice -= this.monthlyRepaymentPrice;
		return false;
	}
}
