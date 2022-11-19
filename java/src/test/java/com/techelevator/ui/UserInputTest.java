package com.techelevator.ui;

import com.techelevator.models.Candy;
import com.techelevator.models.Gum;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class UserInputTest {


    @Test
    public void test_feedMoneyInput_send_in_String_1_return_BigDecimal_1(){

    BigDecimal expected=new BigDecimal("1");
    String input="1";

    Assert.assertEquals(expected,UserInput.feedMoneyInput(input));


}
    @Test
    public void test_feedMoneyInput_send_in_String_5_return_BigDecimal_5(){

        BigDecimal expected=new BigDecimal("5");
        String input="5";

        Assert.assertEquals(expected,UserInput.feedMoneyInput(input));


    }
    @Test
    public void test_feedMoneyInput_send_in_String_10_return_BigDecimal_10(){

        BigDecimal expected=new BigDecimal("10");
        String input="10";

        Assert.assertEquals(expected,UserInput.feedMoneyInput(input));


    }
    @Test
    public void test_feedMoneyInput_send_in_String_20_return_BigDecimal_20(){

        BigDecimal expected=new BigDecimal("20");
        String input="20";

        Assert.assertEquals(expected,UserInput.feedMoneyInput(input));


    }
    @Test
    public void test_feedMoneyInput_send_in_String_7_return_BigDecimal_0(){

        BigDecimal expected=new BigDecimal("0");
        String input="7";

        Assert.assertEquals(expected,UserInput.feedMoneyInput(input));


    }

    @Test
    public void test_purchaseItemFullPrice_send_in_BigDecimal_5_and_Candy_return_3_Quantity_decrease_by_1(){
    Candy candy=new Candy("Skittles",new BigDecimal("2"),"A1");

    BigDecimal expectedMoney=new BigDecimal("3");
    int expectedQuantity=5;
    BigDecimal actualMoney=UserInput.purchaseItemFullPrice(new BigDecimal("5"),candy);

    Assert.assertEquals(expectedQuantity,candy.getQuantity());
    Assert.assertEquals(expectedMoney,actualMoney);

    }

    @Test
    public void test_purchaseItemFullPrice_send_in_BigDecimal_10_and_Candy_return_8_Quantity_decrease_by_1(){
        Candy candy=new Candy("Skittles",new BigDecimal("2"),"A1");

        BigDecimal expectedMoney=new BigDecimal("8");
        int expectedQuantity=5;
        BigDecimal actualMoney=UserInput.purchaseItemFullPrice(new BigDecimal("10"),candy);

        Assert.assertEquals(expectedQuantity,candy.getQuantity());
        Assert.assertEquals(expectedMoney,actualMoney);

    }

    @Test
    public void test_purchaseItemFullPrice_send_in_BigDecimal_5_and_Gum_return_3_Quantity_decrease_by_1(){
        Gum gum=new Gum("Gummy",new BigDecimal("2"),"A1");

        BigDecimal expectedMoney=new BigDecimal("3");
        int expectedQuantity=5;
        BigDecimal actualMoney=UserInput.purchaseItemFullPrice(new BigDecimal("5"),gum);

        Assert.assertEquals(expectedQuantity,gum.getQuantity());
        Assert.assertEquals(expectedMoney,actualMoney);

    }

    @Test
    public void test_purchaseItemDollarOff_send_in_BigDecimal_5_and_Candy_return_4_Quantity_decrease_by_1(){
        Candy candy=new Candy("Skittles",new BigDecimal("2"),"A1");

        BigDecimal expectedMoney=new BigDecimal("4");
        int expectedQuantity=5;
        BigDecimal actualMoney=UserInput.purchaseItemDollarOff(new BigDecimal("5"),candy);

        Assert.assertEquals(expectedQuantity,candy.getQuantity());
        Assert.assertEquals(expectedMoney,actualMoney);

    }

    @Test
    public void test_purchaseItemDollarOff_send_in_BigDecimal_10_and_Candy_return_9_Quantity_decrease_by_1(){
        Candy candy=new Candy("Skittles",new BigDecimal("2"),"A1");

        BigDecimal expectedMoney=new BigDecimal("9");
        int expectedQuantity=5;
        BigDecimal actualMoney=UserInput.purchaseItemDollarOff(new BigDecimal("10"),candy);

        Assert.assertEquals(expectedQuantity,candy.getQuantity());
        Assert.assertEquals(expectedMoney,actualMoney);

    }

    @Test
    public void test_purchaseItemDollarOff_send_in_BigDecimal_5_and_Gum_return_4_Quantity_decrease_by_1(){
        Gum gum=new Gum("Gummy",new BigDecimal("2"),"A1");

        BigDecimal expectedMoney=new BigDecimal("4");
        int expectedQuantity=5;
        BigDecimal actualMoney=UserInput.purchaseItemDollarOff(new BigDecimal("5"),gum);

        Assert.assertEquals(expectedQuantity,gum.getQuantity());
        Assert.assertEquals(expectedMoney,actualMoney);

    }



}