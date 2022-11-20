package com.example.fundtransfer.service.client;

import com.example.fundtransfer.dto.client.AddSaldoRequest;
import com.example.fundtransfer.dto.client.MinusSaldoRequest;
import com.example.fundtransfer.fiegnclient.UserClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserClientImpl {
    @Autowired
    private UserClient userClient;

    public boolean addSaldo(AddSaldoRequest addSaldoRequest){
        return userClient.addSaldoUser(addSaldoRequest);
    }
    public boolean minusSaldo(MinusSaldoRequest minusSaldoRequest){
        return userClient.minusSaldo(minusSaldoRequest);
    }

}
