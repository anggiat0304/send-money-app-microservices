package com.example.orderservice.dto.client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestValidation {
    private String phoneNumberTarget;
    private String phoneNumber;
    private int amount;
}
