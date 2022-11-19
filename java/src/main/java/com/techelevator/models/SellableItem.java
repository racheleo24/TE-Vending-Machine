package com.techelevator.models;

import java.math.BigDecimal;

public abstract class SellableItem {

    // Properties
    private  String name;
    private BigDecimal price;
    private String message;
    private  String slotIdentifier;
    private  int quantity;
    private BigDecimal amountSoldFull=new BigDecimal("0");
    private BigDecimal getAmountSoldBOGODO=new BigDecimal("0");

    // Constructor
    public SellableItem(String name, BigDecimal price, String message, String slotIdentifier) {
        this.name = name;
        this.price = price;
        this.message = message;
        this.slotIdentifier = slotIdentifier;
        this.quantity=6;
    }

    // Getters and Setters
    public  String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public  BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public  String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public  String getSlotIdentifier() {
        return slotIdentifier;
    }
    public void setSlotIdentifier(String slotIdentifier) {
        this.slotIdentifier = slotIdentifier;
    }
    public  int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public BigDecimal getAmountSoldFull() {
        return amountSoldFull;
    }
    public void setAmountSoldFull(BigDecimal amountSoldFull) {
        this.amountSoldFull = amountSoldFull;
    }
    public BigDecimal getGetAmountSoldBOGODO() {
        return getAmountSoldBOGODO;
    }
    public void setGetAmountSoldBOGODO(BigDecimal getAmountSoldBOGODO) {
        this.getAmountSoldBOGODO = getAmountSoldBOGODO;
    }


}
