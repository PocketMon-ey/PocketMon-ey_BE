package com.pocketmoney.loan.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.pocketmoney.loan.entity.LoanEntity;

@Mapper
public interface LoanDAO {
	List<LoanEntity> selectLoanList(int status) throws Exception;
	LoanEntity selectLoan(int loanId) throws Exception;
	void insertLoan(LoanEntity loan) throws Exception;
	void updateLoan(LoanEntity loan) throws Exception;
	void deleteLoan(int loanId) throws Exception;
}
