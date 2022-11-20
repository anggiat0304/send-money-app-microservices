package com.example.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
    private Integer id;
    private String target;
    private String user;
    private int amount;
    private String action;
    private String status;

}
