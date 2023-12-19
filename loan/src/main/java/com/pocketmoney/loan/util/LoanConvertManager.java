package com.pocketmoney.loan.util;

import java.util.List;
import java.util.stream.Collectors;

import com.pocketmoney.loan.dto.LoanListResponseDTO;
import com.pocketmoney.loan.entity.LoanEntity;

public class LoanConvertManager {
	private LoanConverter lc;
	
	public LoanListResponseDTO converter(List<LoanEntity> loanEntityList) {
		return new LoanListResponseDTO(
				loanEntityList.stream()
				.map( loanEntity -> lc.LoanEntityToDTO(loanEntity))
				.collect(Collectors.toList())
				);
				
	}
}

