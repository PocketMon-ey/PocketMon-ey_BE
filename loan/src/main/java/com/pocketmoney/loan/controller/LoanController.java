package com.pocketmoney.loan.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pocketmoney.loan.dto.LoanListResponseDTO;
import com.pocketmoney.loan.dto.LoanPostRequestDTO;
import com.pocketmoney.loan.dto.RejectRequestDTO;
import com.pocketmoney.loan.dto.TableListRequestDTO;
import com.pocketmoney.loan.dto.TableListResponseDTO;
import com.pocketmoney.loan.entity.LoanEntity;
import com.pocketmoney.loan.service.LoanService;

import io.swagger.annotations.ApiOperation;

@RestController
public class LoanController {
	
	@Autowired
	private LoanService ls;
	
	@ApiOperation(value = "대출 리스트 조회")
	@GetMapping(value = "list/{status}")
	public ResponseEntity<LoanListResponseDTO> loanList(@PathVariable("status")int status) {
		try {
			LoanListResponseDTO result = ls.fetchLoanList(status);
			return new ResponseEntity<LoanListResponseDTO>(result,HttpStatus.OK);	
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@ApiOperation(value = "대출 등록")
	@PostMapping(value = "/")
	public ResponseEntity<LoanEntity> addLoan(@RequestBody LoanPostRequestDTO req) {
		try {
			LoanEntity result = ls.addLoan(req);
			return new ResponseEntity<LoanEntity>(result,HttpStatus.OK);
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
	@ApiOperation(value = "대출 심사 승인")
	@PostMapping(value = "approve")
	public ResponseEntity<LoanEntity> approveLoan(@RequestBody ApproveRequestDTO req) {
		try {
			
			LoanEntity le = ls.approveLoan(req.getLoanId());
			return new ResponseEntity<LoanEntity>(le,HttpStatus.OK);
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
	@ApiOperation(value = "대출 심사 거절")
	@PostMapping(value = "/refuse")
	public ResponseEntity<LoanEntity> refuseLoan(@RequestBody RejectRequestDTO req) {
		try {
			LoanEntity le = ls.refuseLoan(req);
			return new ResponseEntity<LoanEntity>(le,HttpStatus.OK);
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@ApiOperation(value = "대출 납입")
	@PostMapping(value = "/repayment")
	public ResponseEntity<LoanEntity> payLoanMoney(@RequestBody ApproveRequestDTO req) {
		try {
			LoanEntity le = ls.payLoanMoney(req);
			return new ResponseEntity<LoanEntity>(le,HttpStatus.OK);
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@ApiOperation(value = "대출 기간 목록 조회")
	@PostMapping(value = "/tableList")
	public ResponseEntity<TableListResponseDTO> tableList(@RequestBody TableListRequestDTO req) {
		try {
			TableListResponseDTO dto = ls.tableList(req);
			return new ResponseEntity<TableListResponseDTO>(dto,HttpStatus.OK);
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
}
