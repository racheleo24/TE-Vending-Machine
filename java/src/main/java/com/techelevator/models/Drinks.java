package com.techelevator.models;

import java.math.BigDecimal;

public class Drinks extends SellableItem{

    public Drinks(String name, BigDecimal price, String slotIdentifier) {
        super(name, price, "Drinky, Drinky, Slurp Slurp!", slotIdentifier);
    }
}