package com.example.fundtransfer.service;

import com.example.fundtransfer.dto.FundRequest;
import com.example.fundtransfer.dto.FundResponse;
import com.example.fundtransfer.dto.client.AddSaldoRequest;
import com.example.fundtransfer.dto.client.MinusSaldoRequest;
import com.example.fundtransfer.model.FundPay;
import com.example.fundtransfer.repository.FundRepository;
import com.example.fundtransfer.service.client.UserClientImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class FundService {
    private final FundRepository fundRepository;
    private final UserClientImpl userClient;

    public boolean pay(FundRequest fundRequest){
        MinusSaldoRequest minusSaldoRequest = new MinusSaldoRequest();
        minusSaldoRequest.setPhoneNumber(fundRequest.getUser());
        minusSaldoRequest.setAmount(fundRequest.getAmount());

        AddSaldoRequest addSaldoRequest = new AddSaldoRequest();
        addSaldoRequest.setPhoneNumber(fundRequest.getTarget());
        addSaldoRequest.setAmount(fundRequest.getAmount());

        FundPay fundPay = new FundPay();
        fundPay.setUser(fundRequest.getUser());
        fundPay.setAmount(fundRequest.getAmount());
        fundPay.setTarget(fundRequest.getTarget());
        fundPay.setAction(fundRequest.getAction());
        fundPay.setStatus("PAY");


        if (userClient.minusSaldo(minusSaldoRequest)){
            if (userClient.addSaldo(addSaldoRequest)){
                fundRepository.save(fundPay);
                return true;
            }
        }
        return false;
    }

    public List<FundPay> allTransaction(){
        List<FundPay> fundPay = fundRepository.findAll();
        return fundPay;
    }
}
