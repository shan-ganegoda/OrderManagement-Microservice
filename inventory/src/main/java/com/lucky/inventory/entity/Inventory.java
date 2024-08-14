package com.lucky.inventory.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "inventory")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "itemid")
    private Integer itemid;

    @Column(name = "productid")
    private Integer productid;

    @Column(name = "quentity")
    private Integer quentity;

}