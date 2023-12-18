package com.pocketmoney.loan.dto;

import java.util.List;

import com.pocketmoney.loan.model.Loan;

import lombok.Data;

@Data
public class LoanListResponseDTO {
	private final String message;
	private final List<Loan> loanList;
	
	public LoanListResponseDTO(List<Loan> b) {
		// TODO Auto-generated constructor stub
		this.message = "테스트";
		this.loanList = b;
	}
}