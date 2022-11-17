package com.techelevator.application;

import com.techelevator.models.*;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VendingMachine 
{

    private final String FILE1="catering.csv";
    private final String FILE2="catering1.csv";
    private static BigDecimal currentMoney = new BigDecimal("0.00");

    public static BigDecimal getCurrentMoney() {
        return currentMoney;
    }

    public void run()
    {
        while(true)
        {
            UserOutput.displayHomeScreen();
            String choice = UserInput.getHomeScreenOption();

            if(choice.equals("display"))
            {
               System.out.printf("%-4s %-20s %-10s %-4s\n","ID","Name","Price","Quantity");
               for(SellableItem item:readFile(FILE1)){
                   System.out.printf("%-4s %-20s $%-10.2f %-4s\n", item.getSlotIdentifier(),item.getName(),item.getPrice(),item.getQuantity());
               }
                // display the vending machine slots
            }
            else if(choice.equals("purchase"))
            {
                // make a purchase
                purchaseScreen();
            }
            else if(choice.equals("exit"))
            {
                // good bye
                break;
            }
        }


    }

    public List<SellableItem> readFile(String input){
        File file=new File(input);
        List<SellableItem> items=new ArrayList<>();

        try(Scanner scanner=new Scanner(file)){
            while (scanner.hasNextLine()){
                String line=scanner.nextLine();
                String [] splitLine=line.split(",");
                if(splitLine[3].equalsIgnoreCase("Munchy")){
                    items.add(new Munchy(splitLine[1],new BigDecimal(splitLine[2]),splitLine[0]));

                } if(splitLine[3].equalsIgnoreCase("Gum")){
                    items.add(new Gum(splitLine[1],new BigDecimal(splitLine[2]),splitLine[0]));

                } if(splitLine[3].equalsIgnoreCase("Drink")){
                    items.add(new Drinks(splitLine[1],new BigDecimal(splitLine[2]),splitLine[0]));

                } if(splitLine[3].equalsIgnoreCase("Candy")){
                    items.add(new Candy(splitLine[1],new BigDecimal(splitLine[2]),splitLine[0]));
                }
            }

        }catch(FileNotFoundException e){
            System.out.println("Error! File could not be read");
            System.exit(1);
        }
        return items;
    }

    public void purchaseScreen() {
        while (true) {
            String choice = UserInput.getPurchaseScreenOption();
            Scanner input = new Scanner(System.in);

            if (choice.equals("feed money")) {
                BigDecimal newMoney = UserInput.feedMoneyInput();
                currentMoney.add(newMoney);

            } else if (choice.equals("select item")) {

                System.out.printf("%-4s %-20s %-10s %-4s\n", "ID", "Name", "Price", "Quantity");
                for (SellableItem item : readFile(FILE1)) {
                    System.out.printf("%-4s %-20s $%-10.2f %-4s\n", item.getSlotIdentifier(), item.getName(), item.getPrice(), item.getQuantity());
                }
                // make a purchase

            } else if (choice.equals("finish")) {
                // good bye
                break;
            }
        }
    }

}
