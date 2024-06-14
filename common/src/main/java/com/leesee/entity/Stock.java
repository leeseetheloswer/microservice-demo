package com.leesee.entity;

import lombok.Data;

@Data
public class Stock {
    Long productId;
    Long warehouseId;
    Integer amount;
}
