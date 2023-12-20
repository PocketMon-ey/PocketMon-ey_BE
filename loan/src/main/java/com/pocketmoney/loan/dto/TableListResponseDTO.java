package com.pocketmoney.loan.dto;

import java.util.List;

import com.pocketmoney.loan.model.LoanTable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TableListResponseDTO {

	List<LoanTable> list;

	public TableListResponseDTO(List<LoanTable> list) {
		super();
		this.list = list;
	}

}
