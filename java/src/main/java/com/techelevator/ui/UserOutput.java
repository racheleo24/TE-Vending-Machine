package com.techelevator.ui;

import com.techelevator.audit.Audit;
import com.techelevator.models.SellableItem;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * Responsibilities: This class should handle formatting and displaying ALL
 * messages to the user
 * 
 * Dependencies: None
 */
public class UserOutput {

    private static Audit auditor = new Audit("Audit.txt");

    public static void displayMessage(String message) {
        System.out.println();
        System.out.println(message);
        System.out.println();
    }

    public static void displayHomeScreen() {
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

    public static void getChange(BigDecimal currentMoney) {
        int numberDollars = 0;
        int numberQuarters = 0;
        int numberDimes = 0;
        int numberNickels = 0;

        numberDollars = currentMoney.intValue();  //5.65 turns into 5
        BigDecimal intValue=new BigDecimal(numberDollars); //turning 5 back into big decimal
        BigDecimal fractional=currentMoney.subtract(intValue);//5.65-5>>0.65
        BigDecimal fractionalMultipled =fractional.multiply(new BigDecimal("100")); //0.65*100=65
        BigDecimal divisibleByFive=fractionalMultipled.divide(new BigDecimal("5"));  //65/5=13
        int divisibleByFiveInt=divisibleByFive.intValue();//turning 13 into an int

        for (int i=0;i<=divisibleByFiveInt;i++) {
            if (divisibleByFiveInt >= 5) {
                numberQuarters++;
                divisibleByFiveInt -= 5;
            }
            if (divisibleByFiveInt < 5 && divisibleByFiveInt >= 2) {
                numberDimes++;
                divisibleByFiveInt -= 2;
            } else {
                numberNickels++;
                divisibleByFiveInt--;
            }
        }
        System.out.println("\nYour change is: $" + currentMoney);
        System.out.println("Now dispensing: " + numberDollars + " dollars, " +
                numberQuarters + " quarters, " +
                numberDimes + " dimes, and " +
                numberNickels + " nickel.");

        auditor.write(LocalDateTime.now() + "-- CHANGE GIVEN: $" + currentMoney + " , " +
                 "REMAINING BALANCE: $" + (currentMoney.subtract(currentMoney)));
    }

    public static void getTotalSalesReport(Audit audit, List<SellableItem> itemList){
        BigDecimal total=new BigDecimal("0.00");

        audit.write("Taste Elevator Sales Report");
        for(SellableItem item:itemList) {
            audit.write(item.getName() + "|" + item.getAmountSoldFull()+"|"+item.getGetAmountSoldBOGODO());
            BigDecimal fullPurchase=(item.getPrice().multiply(item.getAmountSoldFull()));
            BigDecimal discountPurchase=(((item.getPrice().subtract(new BigDecimal("1"))).multiply(item.getGetAmountSoldBOGODO())));
            total=total.add(fullPurchase.add(discountPurchase));
        }
        audit.write("TOTAL SALES: "+"$"+total);
    }
}
