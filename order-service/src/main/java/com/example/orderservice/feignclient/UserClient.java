package com.example.orderservice.feignclient;

import com.example.orderservice.dto.client.UserRequestValidation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "user-service" , url = "http://localhost:8081")
public interface UserClient {
    @PostMapping("/api/user/validation")
    public boolean valid(@RequestBody UserRequestValidation userRequest);
}
