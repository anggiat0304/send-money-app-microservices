package com.example.userservice.controller;

import com.example.userservice.dto.*;
import com.example.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @PostMapping("/add")
    public void addUser(@RequestBody AddUserRequest userRequest){
        userService.addUser(userRequest);
    }

    @GetMapping("/all")
    public List<UserResponse> getAllUser(){
       return  userService.getALlUsers();
    }

    @PostMapping("/validation")
    public boolean valid(@RequestBody UserRequestValidation userRequest){
        return userService.validation(userRequest);
    }

    @PostMapping("/addSaldo")
    public boolean addSaldoUser(@RequestBody AddSaldoRequest addSaldoRequest){
        return userService.addSaldo(addSaldoRequest);
    }

    @PostMapping("/minusSaldo")
    public boolean minusSaldo(@RequestBody MinusSaldoRequest minusSaldoRequest){
        return userService.minusSaldo(minusSaldoRequest);
    }

}
