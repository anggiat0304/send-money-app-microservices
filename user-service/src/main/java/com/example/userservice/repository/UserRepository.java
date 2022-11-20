package com.example.userservice.repository;

import com.example.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepository extends JpaRepository<User , Integer> {

    @Query(value = "SELECT * FROM t_user WHERE phone_number IN (:phoneNumber,:phoneNumberTarget) ", nativeQuery = true)
    public User getUserByPhoneNumber(String phoneNumber , String phoneNumberTarget);

    @Query(value = "UPDATE t_user SET saldo= saldo + :amount WHERE phone_number = :phoneNumber", nativeQuery = true)
    public boolean addSaldoUser(String phoneNumber , Integer amount);

    @Query(value = "UPDATE t_user SET saldo= saldo - :amount WHERE phone_number = :phoneNumber", nativeQuery = true)
    public boolean minusSaldoUser(String phoneNumber , Integer amount);

}
