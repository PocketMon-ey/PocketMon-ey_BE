package com.pocketmoney.loan.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TableListRequestDTO {
	int price;
	int loanInterest;
	
	
	public int getTotalPrice(int month) {
		double loanRate = (double)loanInterest / 100;
		double monthRate = (double)month / 12;
		int result = (int)(price + price * loanRate * monthRate) / month * month;
		return result;
	}
	
	public int getPricePerMonth(int month) {
		return getTotalPrice(month) / month;
	}
	
}
