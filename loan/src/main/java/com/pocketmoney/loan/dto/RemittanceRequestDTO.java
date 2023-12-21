package com.pocketmoney.loan.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RemittanceRequestDTO {
	int id1;
	int id2;
	int price;
	
	public RemittanceRequestDTO(int id1, int id2, int price) {
		super();
		this.id1 = id1;
		this.id2 = id2;
		this.price = price;
	}
}
