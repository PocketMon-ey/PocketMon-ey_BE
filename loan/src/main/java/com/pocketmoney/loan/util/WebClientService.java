package com.pocketmoney.loan.util;

import java.util.List;

import org.springframework.web.reactive.function.client.WebClient;

import com.pocketmoney.loan.dto.RemittanceRequestDTO;

public class WebClientService {
    public void sendMoney(int fromId, int toId, int price) {
        // webClient 기본 설정
        WebClient webClient = WebClient
                        .builder()
                        .baseUrl("http://pocketmoney.165.192.105.60.nip.io")
                        .build();
        RemittanceRequestDTO req = new RemittanceRequestDTO(fromId, toId, price);
        try {
                    webClient
                            .post()
                            .uri(uriBuilder ->
                                    uriBuilder
                                            .path("/user/transaction")
                                            .build())
                            .header("Content-Type", "application/json")
                            .bodyValue(req)
                            .retrieve()
                            .bodyToMono(List.class)
                            .block();
                    System.out.println("a");
                    System.out.println(fromId);
                    System.out.println("b");
                    System.out.println(toId);
                    System.out.println("c");
                    System.out.println(price);
        } catch(Exception e) {
        	throw new RuntimeException(e);
        }
    }
    
    public int getParentId(int childId) {
      

        // webClient 기본 설정
        WebClient webClient = WebClient
                        .builder()
                        .baseUrl("http://pocketmoney.165.192.105.60.nip.io")
                        .build();
        try {
        	int response =
                    webClient
                            .get()
                            .uri(uriBuilder ->
                                    uriBuilder
                                            .path("/user/carer/" + String.valueOf(childId))
                                            .build())
                            .retrieve()
                            .bodyToMono(int.class)
                            .block();
        	System.out.println(response);
        	 return response;
        } catch(Exception e) {
        	throw new RuntimeException(e);
        }
    }
}
