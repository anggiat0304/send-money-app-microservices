package com.example.orderservice.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderCreatedResponse {
    public String message;
}
