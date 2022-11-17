package com.techelevator.models;

import java.math.BigDecimal;

public class Gum extends SellableItem{

    public Gum(String name, BigDecimal price, String slotIdentifier) {
        super(name, price, "Chewy, Chewy, Lots O Bubbles!", slotIdentifier);
    }
}
