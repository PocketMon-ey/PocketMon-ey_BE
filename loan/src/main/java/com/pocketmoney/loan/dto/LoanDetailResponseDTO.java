package com.pocketmoney.loan.dto;

import lombok.Data;

@Data
public class LoanDetailResponseDTO {
	private final String reason;
	private final String totalmoney;
	private final int repayment;
	private final double interestrate;
	private final int moneyPerMonth;
	private final int period;
	private final String startDate;
	private final String endDate;
}