package com.pocketmoney.loan.util;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.pocketmoney.loan.dto.LoanListResponseDTO;
import com.pocketmoney.loan.entity.LoanEntity;
import com.pocketmoney.loan.model.Loan;

@Component
public class LoanConverter {
	public Loan LoanEntityToDTO(LoanEntity lc) {
		return new Loan(
				lc.getId(),
				lc.getReason(),
				lc.getPrice(),
				lc.getTotalPrice(),
				lc.getStartDate(),
				lc.getEndDate(),
				lc.getPeriod(),
				lc.getStatus()
				);
	}
	
	public LoanListResponseDTO converter(List<LoanEntity> loanEntityList) {
		return new LoanListResponseDTO(
				loanEntityList.stream()
				.map( loanEntity -> LoanEntityToDTO(loanEntity))
				.collect(Collectors.toList())
				);
	}
}
