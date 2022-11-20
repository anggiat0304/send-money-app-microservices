package com.example.orderservice.service.client;

import com.example.orderservice.dto.client.UserRequestValidation;
import com.example.orderservice.feignclient.UserClient;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
@Getter
@Setter
public class UserClientImpl {
      @Autowired
      private final UserClient userClient;

      public boolean validation(UserRequestValidation userRequestValidation){
            return userClient.valid(userRequestValidation);
      }


}