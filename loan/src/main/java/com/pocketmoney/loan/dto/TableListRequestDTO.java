package com.pocketmoney.loan.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TableListRequestDTO {
	int price;
	int loanInterest;
	
	
	public int getTotalPrice(int month) {
		return price + price * loanInterest / month;
	}
	
	public int getPricePerMonth(int month) {
		return getTotalPrice(month) / month;
	}
	
}
