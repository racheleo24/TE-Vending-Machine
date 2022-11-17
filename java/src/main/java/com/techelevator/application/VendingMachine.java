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
                UserInput.purchaseScreen(currentMoney, itemList);
            }
            else if(choice.equals("exit"))
            {
                // goodbye
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
        } catch(FileNotFoundException e){
            UserOutput.fileError();
            System.exit(1);
        }
        return items;
    }

}
