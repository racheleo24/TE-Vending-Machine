package com.techelevator.ui;

import com.techelevator.application.VendingMachine;
import com.techelevator.audit.Audit;
import com.techelevator.models.SellableItem;

import java.math.BigDecimal;
import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

/**
 * Responsibilities: This class should handle receiving ALL input from the User
 * 
 * Dependencies: None
 */
public class UserInput
{
    private static Audit auditor = new Audit("Audit.txt");

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
        int count = 1;

        while (true) {
            String choice = getPurchaseScreenOption(currentMoney);

            if (choice.equals("feed money")) {
                System.out.print("\nHow much money would you like to enter? ");
                String inputMoney = scanner.nextLine();
                currentMoney = currentMoney.add(feedMoneyInput(inputMoney));
                auditor.write(LocalDateTime.now() + "-- MONEY FED: $" + inputMoney + ", CURRENT MONEY: $" + currentMoney);

            } else if (choice.equals("select item")) {
                UserOutput.displayItems(itemList);

                System.out.print("\nEnter the ID of the item you would like to purchase: ");
                String id = scanner.nextLine();

                int tally=0;
                for (SellableItem item:itemList){

                    if (item.getSlotIdentifier().equalsIgnoreCase(id) && item.getQuantity()>0){
                        if (count % 2 == 0) {
                            BigDecimal dollarOffPrice = (item.getPrice().subtract(new BigDecimal("1")));
                            if (currentMoney.compareTo(dollarOffPrice) >= 0) {
                                auditor.write(LocalDateTime.now() + "-- PURCHASED: " + item.getName() + " , " +
                                        item.getSlotIdentifier() + " , START MONEY: $" + currentMoney +
                                        " , FINAL MONEY: $" + (currentMoney.subtract(dollarOffPrice)));
                                currentMoney = purchaseItemDollarOff(currentMoney, item);
                                count++;
                            }
                            else {
                                System.out.println("\nInsufficient funds");
                            }
                        } else {
                            if (currentMoney.compareTo(item.getPrice()) >= 0) {
                                auditor.write(LocalDateTime.now() + "-- PURCHASED: " + item.getName() + " , " +
                                        item.getSlotIdentifier() + " , START MONEY: $" + currentMoney +
                                        " , FINAL MONEY: $" + (currentMoney.subtract(item.getPrice())));
                                currentMoney = purchaseItemFullPrice(currentMoney, item);
                                count++;
                            }
                            else {
                                System.out.println("\nInsufficient funds");
                            }
                        }
                        tally++;
                    }
                    else if (item.getQuantity() <= 0) {
                        System.out.println("\nProduct no longer available");
                        tally++;

                    }

                    }
                if(tally==0){
                    System.out.println("Product Not Found");

                }

            }

            else if (choice.equals("finish")) {
                UserOutput.getChange(currentMoney);
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
            System.out.println("\nInvalid entry! Taste Elevator only accepts $1, $5, $10, or $20.");
            return new BigDecimal("0");
        }
    }
    public static BigDecimal purchaseItemFullPrice(BigDecimal currentMoney, SellableItem item){

        BigDecimal spent;
        spent=item.getPrice();
        currentMoney = currentMoney.subtract(spent);
        item.setQuantity(item.getQuantity()-1);
        System.out.println("\nNow dispensing " + item.getName() + ", " +"$"+ spent);
        System.out.println(item.getMessage());
        return currentMoney;

    }


    public static BigDecimal purchaseItemDollarOff(BigDecimal currentMoney, SellableItem item){

        BigDecimal spent;
        spent=item.getPrice().subtract(new BigDecimal("1"));
        currentMoney = currentMoney.subtract(spent);
        item.setQuantity(item.getQuantity()-1);
        System.out.println("\nNow dispensing " + item.getName() + ", " +"BOGODO-One Dollar Off! $"+ spent);
        System.out.println(item.getMessage());
        return currentMoney;
    }





}
