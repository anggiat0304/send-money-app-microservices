package com.example.fundtransfer.dto.client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MinusSaldoRequest {
    private String phoneNumber;
    private Integer amount;
}
