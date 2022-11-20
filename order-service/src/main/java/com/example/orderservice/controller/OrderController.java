package com.example.orderservice.controller;

import com.example.orderservice.dto.OrderCreatedResponse;
import com.example.orderservice.dto.OrderRequest;
import com.example.orderservice.dto.OrderResponse;
import com.example.orderservice.model.Order;
import com.example.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public OrderCreatedResponse createOrder(@RequestBody OrderRequest orderRequest){
        String response = orderService.createOrder(orderRequest);
        return new OrderCreatedResponse(response);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OrderResponse> getAllOrders(){
       return orderService.getAllOrders();
    }

}
