package com.pocketmoney.loan.model;

import lombok.Data;

@Data
public class Loan {
	public Loan(int id2, String reason2, int price2, int totalPrice2, String startDate2, String endDate2, int period2,
			int status2) {
		this.id = id2;
		this.reason = reason2;
		this.price = price2;
		this.totalPrice = totalPrice2;
		this.startDate = startDate2;
		this.endDate = endDate2;
		this.period = period2;
		this.status = status2;
	}
	int id;
	String reason;
	int price;
	int totalPrice;
	String startDate;
	String endDate;
	int period;
	int status;
}
