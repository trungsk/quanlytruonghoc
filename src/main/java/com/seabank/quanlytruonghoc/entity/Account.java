package com.seabank.quanlytruonghoc.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "ten")
    private String ten;

    @Column(name = "stk")
    private String stk;

    @Column(name = "so_tien")
    private Long soTien;

}