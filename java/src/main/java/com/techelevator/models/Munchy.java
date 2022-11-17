package com.techelevator.models;

import java.math.BigDecimal;

public class Munchy extends SellableItem{

    public Munchy(String name, BigDecimal price, String slotIdentifier) {
        super(name, price, "Munchy, Munchy, so Good!", slotIdentifier);
    }
}
