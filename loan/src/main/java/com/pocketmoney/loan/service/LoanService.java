package com.pocketmoney.loan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pocketmoney.loan.dto.LoanListResponseDTO;
import com.pocketmoney.loan.entity.LoanEntity;
import com.pocketmoney.loan.util.LoanConverter;
import com.pocketmoney.loan.dao.LoanDAO;

@Service
public class LoanService {
	@Autowired
	private LoanDAO loanDao;
	@Autowired
	private LoanConverter lc;
	
	public LoanListResponseDTO fetchLoanList(int status) {
		try {
			System.out.println(status);
			System.out.println("Asdasdasdads");
			List<LoanEntity> loanList = loanDao.selectLoanList(status);
			System.out.println(loanList);
			System.out.println("asdaasd");
			LoanListResponseDTO loanListRes = lc.converter(loanList);
			return loanListRes;
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
}