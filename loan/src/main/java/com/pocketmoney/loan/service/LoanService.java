package com.pocketmoney.loan.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.pocketmoney.loan.dto.LoanListResponseDTO;
import com.pocketmoney.loan.dto.LoanPostRequestDTO;
import com.pocketmoney.loan.dto.RejectRequestDTO;
import com.pocketmoney.loan.dto.TableListRequestDTO;
import com.pocketmoney.loan.dto.TableListResponseDTO;
import com.pocketmoney.loan.entity.LoanEntity;
import com.pocketmoney.loan.model.LoanTable;
import com.pocketmoney.loan.util.LoanConverter;
import com.pocketmoney.loan.controller.ApproveRequestDTO;
import com.pocketmoney.loan.dao.LoanDAO;

@Service
public class LoanService {
	@Autowired
	private LoanDAO loanDao;
	@Autowired
	private LoanConverter lc;
	
	
	public LoanListResponseDTO fetchLoanList(int status) {
		try {
			List<LoanEntity> loanList = loanDao.selectLoanList(status);
			LoanListResponseDTO loanListRes = lc.converter(loanList);
			return loanListRes;
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public LoanEntity addLoan(LoanPostRequestDTO req) {
		try { 
			LoanEntity loan = new LoanEntity(
					-1,
					req.getReason(),
					req.getPrice(),
					req.getTotalPrice(),
					req.getTotalPrice(),
					req.getLoanInterest(),
					req.getPricePerMonth(),
					req.getPeriod(),
					null,
					null,
					0,
					0,
					null,
					null,
					null,
					req.getChildId()
					);
			loanDao.insertLoan(loan);
			LoanEntity result = loanDao.selectLoanList(0).get(0);
			return result;
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public LoanEntity approveLoan(int loanId) {
		try {
			// TODO 날짜 , 납입일 
			
			LoanEntity le = loanDao.selectLoan(loanId);
			le.setStatus(1);
			LocalDate now = LocalDate.now();
			loanDao.updateLoan(le);
			return le;
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public LoanEntity refuseLoan(RejectRequestDTO req) {
		try {
			int loanId = req.getLoanId();
			String reason = req.getRejectionReason();
			LoanEntity le = loanDao.selectLoan(loanId);
			le.setStatus(2);
			le.setReason(reason);
			loanDao.updateLoan(le);
			return loanDao.selectLoan(loanId);
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}

	public LoanEntity payLoanMoney(ApproveRequestDTO req) {
		try {
			int loanId = req.getLoanId();
			LoanEntity le = loanDao.selectLoan(loanId);
			le.repay();
			loanDao.updateLoan(le);
			return le;
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public TableListResponseDTO tableList(TableListRequestDTO req) {
		try {
			List<Integer> months = new ArrayList<>();
			
			months.add(1);
			months.add(3);
			months.add(6);
			
			return new TableListResponseDTO(
					months.stream()
					.map(month -> new LoanTable(month, req.getPricePerMonth(month) ,req.getTotalPrice(month)))
					.collect(Collectors.toList())
					);			
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}