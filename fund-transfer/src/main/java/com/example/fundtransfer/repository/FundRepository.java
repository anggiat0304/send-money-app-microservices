package com.example.fundtransfer.repository;

import com.example.fundtransfer.model.FundPay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface FundRepository extends JpaRepository<FundPay, String> {
}
