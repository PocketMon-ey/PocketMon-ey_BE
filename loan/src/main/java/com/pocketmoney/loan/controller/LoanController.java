package com.pocketmoney.loan.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pocketmoney.loan.dto.LoanListResponseDTO;
import com.pocketmoney.loan.model.Loan;
import com.pocketmoney.loan.service.LoanService;

import io.swagger.annotations.ApiOperation;

@RestController
public class LoanController {
	
	@ApiOperation(value = "대출 리스트 조회")
	@GetMapping(value = "/loan/list/{status}")
	public ResponseEntity<LoanListResponseDTO> loanList(@PathVariable("status")int status) {
		LoanService ls = new LoanService();
		LoanListResponseDTO result = ls.fetchLoanList(status);
		return new ResponseEntity<LoanListResponseDTO>(result,HttpStatus.OK);
	}
	
	@ApiOperation(value = "대출 상세조회")
	@GetMapping(value = "/loan/{loanid}")
	public ResponseEntity<Integer> loan(@PathVariable("loanid")int loanId) {
		return new ResponseEntity<Integer>(loanId,HttpStatus.OK);
	}
	
	@ApiOperation(value = "대출 등록")
	@PostMapping(value = "/loan")
	public ResponseEntity<Loan> addLoan(@RequestBody Loan loan) {
		
		return new ResponseEntity<Loan>(loan,HttpStatus.OK);
	}
	
	@ApiOperation(value = "대출 심사 승인")
	@PostMapping(value = "/loan/approve")
	public ResponseEntity<Integer> approveLoan(@RequestBody int loanId) {
		return new ResponseEntity<Integer>(loanId,HttpStatus.OK);
	}
	
	
	@ApiOperation(value = "대출 심사 거절")
	@PostMapping(value = "/loan/refuse")
	public ResponseEntity<Integer> refuseLoan(@RequestBody int loanId) {
		return new ResponseEntity<Integer>(loanId,HttpStatus.OK);
	}
	
	@ApiOperation(value = "대출 납입")
	@PostMapping(value = "/loan/repayment")
	public ResponseEntity<Integer> payLoanMoney(@RequestBody int loanId) {
		return new ResponseEntity<Integer>(loanId,HttpStatus.OK);
	}
}
