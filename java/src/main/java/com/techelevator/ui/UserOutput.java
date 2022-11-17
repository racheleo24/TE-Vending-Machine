package com.techelevator.ui;

import com.techelevator.models.SellableItem;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;


/**
 * Responsibilities: This class should handle formatting and displaying ALL
 * messages to the user
 * 
 * Dependencies: None
 */
public class UserOutput
{

    public static void displayMessage(String message)
    {
        System.out.println();
        System.out.println(message);
        System.out.println();
    }

    public static void displayHomeScreen()
    {
        System.out.println();
        System.out.println("***************************************************");
        System.out.println("                      Home");
        System.out.println("***************************************************");
        System.out.println();
    }
    public static void displayItems(List<SellableItem> itemList){
        System.out.printf("%-4s %-20s %-10s %-4s\n","ID","Name","Price","Quantity");
        for(SellableItem item:itemList){
            System.out.printf("%-4s %-20s $%-10.2f %-4s\n", item.getSlotIdentifier(),item.getName(),item.getPrice(),item.getQuantity());
        }
    }

    public static void fileError(){
        System.out.println("Error! File could not be read");
    }

}
