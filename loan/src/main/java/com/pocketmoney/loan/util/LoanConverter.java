package com.pocketmoney.loan.util;

import org.mapstruct.Mapper;

import com.pocketmoney.loan.entity.LoanEntity;
import com.pocketmoney.loan.model.Loan;

@Mapper
public interface LoanConverter {
	Loan LoanEntityToDTO(LoanEntity lc);
}
