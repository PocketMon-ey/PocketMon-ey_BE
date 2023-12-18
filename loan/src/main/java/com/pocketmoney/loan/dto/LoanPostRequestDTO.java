package com.pocketmoney.loan.dto;

import lombok.Data;

@Data
public class LoanPostRequestDTO {
	private final String reason;
	private final int totalmoney;
	private final int period;
}
