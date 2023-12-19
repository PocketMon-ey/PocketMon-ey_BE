package com.pocketmoney.loan.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pocketmoney.loan.dto.LoanListResponseDTO;
import com.pocketmoney.loan.entity.LoanEntity;
import com.pocketmoney.loan.model.Loan;
import com.pocketmoney.loan.util.LoanConvertManager;
import com.pocketmoney.loan.util.LoanConverter;
import com.pocketmoney.loan.dao.LoanDAO;

@Service
public class LoanService {
	@Autowired
	private LoanDAO loanDao;
	private LoanConvertManager lcm = new LoanConvertManager();
	
	int id;
	String reason;
	int price;
	int totalPrice;
	String startDate;
	String endDate;
	int period;
	int status;
	
	public LoanListResponseDTO fetchLoanList(int status) {
		try {
			System.out.println(status);
			System.out.println("Asdasdasdads");
			List<LoanEntity> loanList = loanDao.selectLoanList(status);
			System.out.println(loanList);
			System.out.println("asdaasd");
			LoanListResponseDTO loanListRes = lcm.converter(loanList);
			return loanListRes;
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	
}