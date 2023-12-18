package com.pocketmoney.loan.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pocketmoney.loan.dto.LoanListResponseDTO;
import com.pocketmoney.loan.service.LoanService;

import io.swagger.annotations.ApiOperation;

@RestController
public class LoanController {
	
	@ApiOperation(value = "대출 리스트 조")
	@GetMapping(value = "/loan/list")
	public ResponseEntity<LoanListResponseDTO> loanList(@PathVariable("status")int status) {
		LoanService ls = new LoanService();
		LoanListResponseDTO result = ls.fetchLoanList(status);
		return new ResponseEntity<LoanListResponseDTO>(result,HttpStatus.OK);
	}
	
	@GetMapping(value = "/loan/listssss")
	public int loanList() {
		return 1;
	}
	
}
