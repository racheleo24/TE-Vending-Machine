package com.techelevator.models;

import java.math.BigDecimal;

public abstract class SellableItem {

    // Properties
    private String name;
    private BigDecimal price;
    private String message;
    private String slotIdentifier;

    // Constructor
    public SellableItem(String name, BigDecimal price, String message, String slotIdentifier) {
        this.name = name;
        this.price = price;
        this.message = message;
        this.slotIdentifier = slotIdentifier;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getSlotIdentifier() {
        return slotIdentifier;
    }
    public void setSlotIdentifier(String slotIdentifier) {
        this.slotIdentifier = slotIdentifier;
    }

    // Methods
    @Override
    public String toString() {
        return "SellableItem{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", message='" + message + '\'' +
                ", slotIdentifier='" + slotIdentifier + '\'' +
                '}';
    }
}
