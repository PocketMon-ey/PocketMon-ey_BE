package com.pocketmoney.loan.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pocketmoney.loan.dto.ApproveRequestDTO;
import com.pocketmoney.loan.dto.LoanListResponseDTO;
import com.pocketmoney.loan.dto.LoanPostRequestDTO;
import com.pocketmoney.loan.dto.RejectRequestDTO;
import com.pocketmoney.loan.dto.TableListRequestDTO;
import com.pocketmoney.loan.dto.TableListResponseDTO;
import com.pocketmoney.loan.entity.LoanEntity;
import com.pocketmoney.loan.model.LoanTable;
import com.pocketmoney.loan.util.LoanConverter;
import com.pocketmoney.loan.util.WebClientService;
import com.pocketmoney.loan.dao.LoanDAO;

@Service
@Transactional
public class LoanService {
	@Autowired
	private LoanDAO loanDao;
	@Autowired
	private LoanConverter lc;
	
	@Transactional
	public LoanListResponseDTO fetchLoanList(int status) {
		try {
			List<LoanEntity> loanList = loanDao.selectLoanList(status);
			LoanListResponseDTO loanListRes = lc.converter(loanList);
			return loanListRes;
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@Transactional
	public LoanEntity fetchLoan(int loanId) {
		try {
			LoanEntity loan = loanDao.selectLoan(loanId);
			return loan;
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@Transactional
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
			return loanDao.selectLoanList(0).get(0);
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	 
	@Transactional
	public LoanEntity approveLoan(int loanId) {
		try {
			WebClientService wcs = new WebClientService();
			
			LoanEntity le = loanDao.selectLoan(loanId);
			int parentId = wcs.getParentId(le.getChildId());
			wcs.sendMoney(parentId, le.getChildId(), le.getPrice());
	        LocalDate currentDate = LocalDate.now();

	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy.MM.dd");
	        String startDateString = currentDate.format(formatter);

	        int monthsToAdd = le.getPeriod();
	        LocalDate endDate = currentDate.plusMonths(monthsToAdd);

	     
	        int lastDayOfMonth = endDate.lengthOfMonth();
	        int dayOfMonth = Math.min(currentDate.getDayOfMonth(), lastDayOfMonth);
	        
	        endDate = endDate.withDayOfMonth(dayOfMonth);

	        String endDateString = endDate.format(formatter);

	        le.setStartDate(startDateString);
	        le.setEndDate(endDateString);
	        le.setStatus(1);
	        loanDao.updateLoan(le);
			return loanDao.selectLoan(le.getId());
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@Transactional
	public LoanEntity refuseLoan(RejectRequestDTO req) {
		try {
			int loanId = req.getLoanId();
			String reason = req.getRejectionReason();
			LoanEntity le = loanDao.selectLoan(loanId);
			le.setStatus(2);
			le.setReason(reason);
			loanDao.updateLoan(le);
			return loanDao.selectLoan(le.getId());
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Transactional
	public LoanEntity payLoanMoney(ApproveRequestDTO req) {
		try {
			int loanId = req.getLoanId();
			LoanEntity le = loanDao.selectLoan(loanId);
			
			if(le.repay()) {
				return loanDao.selectLoan(le.getId());
			}
			WebClientService wcs = new WebClientService();
			int parentId = wcs.getParentId(le.getChildId());
			wcs.sendMoney(le.getChildId(), parentId, le.getMonthlyRepaymentPrice());
			loanDao.updateLoan(le);
			return loanDao.selectLoan(le.getId());
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@Transactional
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