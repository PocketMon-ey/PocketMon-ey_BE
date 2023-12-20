package com.pocketmoney.loan.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RejectRequestDTO {
	int loanId;
	String rejectionReason;
}
