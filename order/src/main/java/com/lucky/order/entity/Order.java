package com.lucky.order.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "`order`")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "itemid")
    private Integer itemid;

    @Column(name = "orderdate", length = 45)
    private String orderdate;

    @Column(name = "amount", precision = 5, scale = 2)
    private BigDecimal amount;

}