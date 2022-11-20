package com.example.userservice.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "t_user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false)
    private String phoneNumber;
    private String name;
    private int saldo;
}
