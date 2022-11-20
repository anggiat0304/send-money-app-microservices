package com.example.fundtransfer.controller;

import com.example.fundtransfer.dto.FundRequest;
import com.example.fundtransfer.model.FundPay;
import com.example.fundtransfer.service.FundService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/fund")
@RequiredArgsConstructor
public class FundController {
    private final FundService fundService;

    @PostMapping("/pay")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public boolean pay(@RequestBody FundRequest fundRequest){
        return fundService.pay(fundRequest);
    }

    @GetMapping("/allTransaction")
    @ResponseStatus(HttpStatus.OK)
    public List<FundPay> allTransaction(){
        return fundService.allTransaction();
    };
}
