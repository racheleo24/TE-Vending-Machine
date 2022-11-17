package com.techelevator.models;

import java.math.BigDecimal;

public class Candy extends SellableItem{

    public Candy(String name, BigDecimal price, String slotIdentifier) {
        super(name, price, "Sugar, Sugar, so Sweet!", slotIdentifier);
    }
}