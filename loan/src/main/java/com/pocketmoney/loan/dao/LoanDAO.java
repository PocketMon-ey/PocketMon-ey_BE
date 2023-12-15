package com.pocketmoney.loan.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.pocketmoney.loan.entity.LoanEntity;

@Mapper
public interface LoanDAO {
	List<LoanEntity> selectLoanList(int userId) throws Exception;
	LoanEntity selectLoan(int loanId) throws Exception;
	int insertLoan(LoanEntity loan) throws Exception;
	int updateLoan(LoanEntity loan) throws Exception;
	int deleteLoan(int loanId) throws Exception;
}
