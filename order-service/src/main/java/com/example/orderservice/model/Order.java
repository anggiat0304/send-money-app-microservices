package com.example.orderservice.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

@Entity
@Table(name = "t_order")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String target;
    private int amount;
    private String user;
    private String status;
    private String action;

}

