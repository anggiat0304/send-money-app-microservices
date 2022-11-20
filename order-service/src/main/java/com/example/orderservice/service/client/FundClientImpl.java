package com.example.orderservice.service.client;

import com.example.orderservice.dto.client.FundRequest;
import com.example.orderservice.dto.client.UserRequestValidation;
import com.example.orderservice.feignclient.FundClient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
@Getter
@Setter
public class FundClientImpl {
    @Autowired
    private final FundClient fundClient;

    public boolean pay(FundRequest fundRequest){
        return fundClient.pay(fundRequest);
    }
}
