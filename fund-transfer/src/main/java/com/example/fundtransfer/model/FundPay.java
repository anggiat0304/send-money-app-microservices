package com.example.fundtransfer.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

@Entity
@Table(name = "t_pay")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FundPay {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String target;
    private String user;
    private int amount;
    private String action;
    private String status;
}
