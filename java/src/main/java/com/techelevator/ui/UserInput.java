package com.techelevator.ui;

import com.techelevator.application.VendingMachine;
import com.techelevator.models.SellableItem;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

/**
 * Responsibilities: This class should handle receiving ALL input from the User
 * 
 * Dependencies: None
 */
public class UserInput
{
    private static Scanner scanner = new Scanner(System.in);

    public static String getHomeScreenOption()
    {
        System.out.println("What would you like to do?");
        System.out.println();

        System.out.println("D) Display Vending Machine Items");
        System.out.println("P) Purchase");
        System.out.println("E) Exit");

        System.out.println();
        System.out.print("Please select an option: ");

        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toUpperCase();

        if (option.equals("D"))
        {
            return "display";
        }
        else if (option.equals("P"))
        {
            return "purchase";
        }
        else if (option.equals("E"))
        {
            return "exit";
        }
        else
        {
            return "";
        }

    }

    public static String getPurchaseScreenOption(BigDecimal currentMoney)
    {
        System.out.println("\nWhat would you like to do?");
        System.out.println();

        System.out.println("M) Feed Money");
        System.out.println("S) Select Item");
        System.out.println("F) Finish Transaction");

        System.out.println();
        System.out.print("Current Money Provided: " + currentMoney);

        System.out.println();
        System.out.print("Please select an option: ");

        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toUpperCase();

        if (option.equals("M"))
        {
            return "feed money";
        }
        else if (option.equals("S"))
        {
            return "select item";
        }
        else if (option.equals("F"))
        {
            return "finish";
        }
        else
        {
            return "";
        }

    }

    public static BigDecimal feedMoneyInput(String feedMoney) {

        if (feedMoney.equals("1") || feedMoney.equals("5") || feedMoney.equals("10") || feedMoney.equals("20")) {
            BigDecimal newMoney = new BigDecimal(feedMoney);
            return newMoney;
        }
        else {
            System.out.println("Invalid entry! Taste Elevator only accepts $1, $5, $10, or $20.");
            return new BigDecimal("0");
        }
    }

    public static BigDecimal charged(String id, List<SellableItem> itemList){
        BigDecimal spent=new BigDecimal("0");
        for (SellableItem item:itemList){
            if(item.getSlotIdentifier().equals(id)){
               spent=item.getPrice();
            }
        }
        return spent;
    }
    public static void updateQuantity(String id, List<SellableItem> itemList){
        for(SellableItem item:itemList){
            if(item.getSlotIdentifier().equals(id)){
                item.setQuantity(item.getQuantity()-1);
            }
        }
    }

}
