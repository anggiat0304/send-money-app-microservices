package com.example.orderservice.feignclient;

import com.example.orderservice.dto.client.FundRequest;
import com.example.orderservice.dto.client.UserRequestValidation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "fund-service" , url = "http://localhost:8082")
public interface FundClient {
    @PostMapping("/api/fund/pay")
    public boolean pay(@RequestBody FundRequest fundRequest);
}
