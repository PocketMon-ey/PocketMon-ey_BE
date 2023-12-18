package com.pocketmoney.loan.entity;


import java.util.Date;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class LoanEntity {
	int id;
	int childId;
	String reason; // 대출 사유 
	int price; // 총 대출 금액 
	int totalPrice; // 갚을 금액 
	int remainPrice;
	Double interestRate;
	int monthlyRepaymentPrice;
	int period;
	String startDate;
	String endDate;
	int repaymentCnt;
	int status;
	String rejectReason;
	Date createDate;
	Date updateDate;
}
