package com.example.fundtransfer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FundRequest {
    private String id;
    private String target;
    private String user;
    private int amount;
    private String action;
}
