package com.pocketmoney.loan.dto;

import java.util.List;

import com.pocketmoney.loan.model.Loan;

import lombok.Data;

@Data
public class LoanListResponseDTO {
	private final List<Loan> loanList;
	
	public LoanListResponseDTO(List<Loan> b) {
		// TODO Auto-generated constructor stub
		this.loanList = b;
	}
}