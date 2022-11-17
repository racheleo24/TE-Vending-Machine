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

    private  final String FILE ="catering.csv"; //enter desired catering file

    private  BigDecimal currentMoney = new BigDecimal("0.00");


    public void run()
    {
        List<SellableItem> itemList=readFile(FILE);
        while(true)
        {
            UserOutput.displayHomeScreen();
            String choice = UserInput.getHomeScreenOption();

            if(choice.equals("display"))
            {
              UserOutput.displayItems(itemList);
                // display the vending machine slots
            }
            else if(choice.equals("purchase"))
            {
                // make a purchase

                purchaseScreen(itemList);
            }
            else if(choice.equals("exit"))
            {
                // good bye
                break;
            }
        }


    }

    public static List<SellableItem> readFile(String input){
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

    public void purchaseScreen(List<SellableItem> itemList) {
        while (true) {
            String choice = UserInput.getPurchaseScreenOption(currentMoney);
            Scanner input = new Scanner(System.in);

            if (choice.equals("feed money")) {
                System.out.print("How much money would you like to enter? ");
                String inputMoney = input.nextLine();
                currentMoney = currentMoney.add(UserInput.feedMoneyInput(inputMoney));

            } else if (choice.equals("select item")) {

                UserOutput.displayItems(itemList);

                System.out.print("Enter the ID of the item you would like to purchase: ");
                String id = input.nextLine();
                for (SellableItem item : itemList) {
                    if (item.getSlotIdentifier().equals(id)) {
                        if (currentMoney.compareTo(item.getPrice()) >= 0) {
                            currentMoney = currentMoney.subtract(UserInput.charged(id,itemList));
                            UserInput.updateQuantity(id,itemList);
                        } else {
                            System.out.println("Insufficient Funds");
                        }
                        if(item.getQuantity()==0){
                            System.out.println("We are out of stock of "+item.getName());
                        }
                    }
                }







            } else if (choice.equals("finish")) {
                currentMoney=new BigDecimal("0.00");

                break;
            }
        }
    }

}
