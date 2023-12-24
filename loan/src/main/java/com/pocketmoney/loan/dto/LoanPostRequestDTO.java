package com.pocketmoney.loan.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class LoanPostRequestDTO {
	private final String reason;
	private final int price; 
	private final int totalPrice;
	private final int period;
	private final double loanInterest;
	private final int pricePerMonth;
	private final int childId;
}
