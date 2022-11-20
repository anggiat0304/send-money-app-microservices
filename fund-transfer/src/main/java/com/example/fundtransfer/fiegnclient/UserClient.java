package com.example.fundtransfer.fiegnclient;


import com.example.fundtransfer.dto.client.AddSaldoRequest;
import com.example.fundtransfer.dto.client.MinusSaldoRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "user-service" , url = "http://localhost:8081")
public interface UserClient {
    @PostMapping("/api/user/addSaldo")
    public boolean addSaldoUser(@RequestBody AddSaldoRequest addSaldoRequest);

    @PostMapping("/api/user/minusSaldo")
    public boolean minusSaldo(@RequestBody MinusSaldoRequest minusSaldoRequest);
}
