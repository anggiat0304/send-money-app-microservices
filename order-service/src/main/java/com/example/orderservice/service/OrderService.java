package com.example.orderservice.service;

import com.example.orderservice.dto.OrderRequest;
import com.example.orderservice.dto.OrderResponse;
import com.example.orderservice.dto.client.FundRequest;
import com.example.orderservice.dto.client.UserRequestValidation;
import com.example.orderservice.kafka.constant.ApplicationConstant;
import com.example.orderservice.model.Order;
import com.example.orderservice.repository.OrderRepository;
import com.example.orderservice.service.client.FundClientImpl;
import com.example.orderservice.service.client.UserClientImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final OrderRepository orderRepository;

    private final UserClientImpl userClient;

    private final FundClientImpl fundClient;

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;
    public String createOrder(OrderRequest orderRequest) {
        String message;

        UserRequestValidation userRequestValidation = new UserRequestValidation();
        userRequestValidation.setPhoneNumber(orderRequest.getUser());
        userRequestValidation.setAmount(orderRequest.getAmount());
        userRequestValidation.setPhoneNumberTarget(orderRequest.getTarget());

        FundRequest fundRequest = new FundRequest();
        fundRequest.setAction(orderRequest.getAction());
        fundRequest.setAmount(orderRequest.getAmount());
        fundRequest.setTarget(orderRequest.getTarget());
        fundRequest.setUser(orderRequest.getUser());

        Order order = new Order();
        order.setUser(orderRequest.getUser());
        order.setAmount(orderRequest.getAmount());
        order.setStatus("INITIAL");
        order.setTarget(orderRequest.getTarget());
        order.setAction(orderRequest.getAction());

        boolean validUser = userClient.validation(userRequestValidation);
        boolean pay = fundClient.pay(fundRequest);
        if (validUser) {
            if (pay) orderRepository.save(order);
            message = "Order Create Success";
            kafkaTemplate.send(ApplicationConstant.TOPIC_NAME , order);
        } else {
            message = "Order Create Failed";
        }
        return message;
    }

    public List<OrderResponse> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        List<OrderResponse> orderResponses = new ArrayList<>();
        for (Order order : orders) {
            orderResponses.add(mapToOrderResponse(order));
        }
        return orderResponses;
    }

    private OrderResponse mapToOrderResponse(Order order) {
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setId(order.getId());
        orderResponse.setTarget(order.getTarget());
        orderResponse.setUser(order.getUser());
        orderResponse.setAmount(order.getAmount());
        orderResponse.setAction(order.getAction());
        orderResponse.setStatus(order.getStatus());
        return orderResponse;
    }


}
