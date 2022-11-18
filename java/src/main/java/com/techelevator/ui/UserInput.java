package com.techelevator.ui;

import com.techelevator.application.VendingMachine;
import com.techelevator.models.SellableItem;

import java.math.BigDecimal;
import java.sql.SQLOutput;
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

    public static void purchaseScreen(BigDecimal currentMoney, List<SellableItem> itemList) {
        while (true) {
            String choice = getPurchaseScreenOption(currentMoney);

            if (choice.equals("feed money")) {
                System.out.print("How much money would you like to enter? ");
                String inputMoney = scanner.nextLine();
                currentMoney = currentMoney.add(feedMoneyInput(inputMoney));

            } else if (choice.equals("select item")) {

                UserOutput.displayItems(itemList);

                System.out.print("Enter the ID of the item you would like to purchase: ");
                String id = scanner.nextLine();
                int count=1;
                for (SellableItem item : itemList) {
                    if (item.getSlotIdentifier().equals(id)) {
                        if (currentMoney.compareTo(item.getPrice()) >= 0) {
                            if (count % 2 == 0) {
                                currentMoney=purchaseItemDollarOff(currentMoney,item);
                            } else {
                                currentMoney = purchaseItemFullPrice(currentMoney,item);
                                
                            }

                            count++;

                        } else{
                                System.out.println("Insufficient Funds");
                            }
                            if (item.getQuantity() == 0) {
                                System.out.println("We are out of stock of " + item.getName());
                            }

                    }

                }
            } else if (choice.equals("finish")) {
                currentMoney = new BigDecimal("0.00");
                break;
            }
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
    public static BigDecimal purchaseItemFullPrice(BigDecimal currentMoney, SellableItem item){

        BigDecimal spent;
        spent=item.getPrice();
        currentMoney = currentMoney.subtract(spent);
        item.setQuantity(item.getQuantity()-1);
        System.out.println(item.getMessage());
        System.out.println("Now dispensing " + item.getName() + ", " + spent);

        return currentMoney;
    }


    public static BigDecimal purchaseItemDollarOff(BigDecimal currentMoney, SellableItem item){

        BigDecimal spent;
        spent=item.getPrice().subtract(new BigDecimal("1"));
        currentMoney = currentMoney.subtract(spent);
        item.setQuantity(item.getQuantity()-1);
        System.out.println(item.getMessage());
        System.out.println("Now dispensing " + item.getName() + ", " + spent);

        return currentMoney;
    }





}
