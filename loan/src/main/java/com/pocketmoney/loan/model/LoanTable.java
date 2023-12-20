package com.pocketmoney.loan.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoanTable {
	int month;
	int pricePerMonth;
	int totalPrice;
	
	public LoanTable(int month, int pricePerMonth, int totalPrice) {
		super();
		this.month = month;
		this.pricePerMonth = pricePerMonth;
		this.totalPrice = totalPrice;
	}

}
