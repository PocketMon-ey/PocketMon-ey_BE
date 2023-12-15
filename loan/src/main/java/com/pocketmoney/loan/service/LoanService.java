package com.pocketmoney.loan.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pocketmoney.loan.dto.LoanListResponseDTO;
import com.pocketmoney.loan.entity.LoanEntity;
import com.pocketmoney.loan.model.Loan;
import com.pocketmoney.loan.dao.LoanDAO;

@Service
public class LoanService {
//	@Autowired
	private LoanDAO loanDao;
	
	int id;
	String reason;
	int price;
	int totalPrice;
	String startDate;
	String endDate;
	int period;
	int status;
	
	public LoanListResponseDTO converter(List<LoanEntity> loanEntityList) {
		return new LoanListResponseDTO(
				loanEntityList.stream()
				.map(loanEntity -> new Loan(loanEntity.getId(),
						loanEntity.getReason(),
						loanEntity.getPrice(),
						loanEntity.getTotalPrice(),
						loanEntity.getStartDate(),
						loanEntity.getEndDate(),
						loanEntity.getPeriod(),
						loanEntity.getStatus()))
				.collect(Collectors.toList())
				);
				
	}
	
	public LoanListResponseDTO fetchLoanList(int userId) {
		try {
			List<LoanEntity> loanList = loanDao.selectLoanList(userId);
			LoanListResponseDTO loanListRes = converter(loanList);
			return loanListRes;
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
}
