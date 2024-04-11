package com.leesee.productclient.pojo;

import lombok.Data;

@Data
public class Product {
    private Long id;
    private String productName;
    private Double price;
    private Long stock;
}

