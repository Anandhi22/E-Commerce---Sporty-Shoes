package com.springbootsportyshoes.demo.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name = "ORDERS")
@Data public class Order {

    @Id
    private Integer orderId;
    private Integer productId;
    private LocalDateTime orderDate;
    private Integer productQuantity;

}
