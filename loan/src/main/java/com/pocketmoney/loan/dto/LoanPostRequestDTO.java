package com.pocketmoney.loan.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class LoanPostRequestDTO {
	private final String reason;
	@NotNull(message="a")
	private final int price; 
	@Min(0)
	@NotNull(message="a")
	private final int totalPrice;
	@Min(0)
	@NotNull(message="a")
	private final int period;
	@Min(0)
	@Max(30)
	@NotNull(message="a")
	private final double loanInterest;
	@NotNull(message="a")
	private final int pricePerMonth;
	@NotNull(message="a")
	private final int childId;
}
