package com.example.userservice.service;

import com.example.userservice.dto.*;
import com.example.userservice.model.User;
import com.example.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public void addUser(AddUserRequest userRequest){
            User user = new User();
            user.setPhoneNumber(userRequest.getPhoneNumber());
            user.setName(userRequest.getName());
            user.setSaldo(userRequest.getSaldo());
            userRepository.save(user);
    }

   public List<UserResponse> getALlUsers(){
        List<User> users= userRepository.findAll();
        return users.stream().map(this::mapToUserResponse).collect(Collectors.toList());
   }

    @Transactional
   public boolean validation(UserRequestValidation userRequest){
        User user = userRepository.getUserByPhoneNumber(userRequest.getPhoneNumber(), userRequest.getPhoneNumberTarget());
        if (user != null && user.getSaldo() >= userRequest.getAmount() ) return true;
        return false;
   }
    private UserResponse mapToUserResponse(User user) {
        return UserResponse.builder()
                .name(user.getName())
                .phoneNumber(user.getPhoneNumber())
                .saldo(user.getSaldo())
                .build();
    }

     public boolean addSaldo (AddSaldoRequest addSaldoRequest){
        boolean addSaldo = userRepository.addSaldoUser(addSaldoRequest.getPhoneNumber(), addSaldoRequest.getAmount());
        if (addSaldo){
            return true;
        }
        return false;
     }
     public boolean minusSaldo(MinusSaldoRequest minusSaldoRequest){
        boolean minusSaldo = userRepository.minusSaldoUser(minusSaldoRequest.getPhoneNumber() , minusSaldoRequest.getAmount());
        if (minusSaldo){
            return true;
        }else{
            return false;
        }
     }
}
