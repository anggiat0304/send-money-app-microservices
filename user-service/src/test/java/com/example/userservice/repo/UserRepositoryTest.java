package com.example.userservice.repo;

import com.example.userservice.model.User;
import com.example.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
@Slf4j
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void getAllUser() {
        List<User> users = userRepository.findAll();
        users.forEach(System.out::println);
    }

    @Test
    public void getUserByPhoneNumber() {
        User user = userRepository.getUserByPhoneNumber("082164462644","08216462222");
        System.out.println(user.getName());
    }

}
