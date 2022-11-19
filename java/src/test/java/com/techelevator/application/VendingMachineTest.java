package com.techelevator.application;

import com.techelevator.models.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class VendingMachineTest {
// public Gum(String name, BigDecimal price, String slotIdentifier) {
    @Test
    public void test_readFile_send_in_catering_csv_return_list () {
        // Arrange
        String source = "catering.csv";
        List<SellableItem> itemList = new ArrayList<>();
        itemList.add(new Gum("U-Chews", new BigDecimal("1.65"), "A1"));
        itemList.add(new Drinks("Ginger Ayle", new BigDecimal("1.85"), "A2"));
        itemList.add(new Candy("Snykkers", new BigDecimal("4.25"), "A3"));
        itemList.add(new Munchy("Chippos", new BigDecimal("3.85"), "A4"));
        itemList.add(new Munchy("Stackers", new BigDecimal("2.65"), "B1"));
        itemList.add(new Drinks("Papsi", new BigDecimal("3.45"), "B2"));
        itemList.add(new Drinks("Mountain Melter", new BigDecimal("3.55"), "B3"));
        itemList.add(new Candy("Wonka Bar", new BigDecimal("2.35"), "B4"));
        itemList.add(new Candy("Caramel Bar", new BigDecimal("2.25"), "C1"));
        itemList.add(new Drinks("7Down", new BigDecimal("3.25"), "C2"));
        itemList.add(new Candy("Moonpie", new BigDecimal("2.95"), "C3"));
        itemList.add(new Munchy("Popcorn", new BigDecimal("1.75"), "C4"));
        itemList.add(new Gum("Teaberry", new BigDecimal("1.65"), "D1"));
        itemList.add(new Munchy("Preengles", new BigDecimal("2.35"), "D2"));
        itemList.add(new Gum("Singlemint Gum", new BigDecimal("2.35"), "D3"));
        itemList.add(new Gum("Chiclets", new BigDecimal("1.35"), "D4"));

        // Act
        List<SellableItem> actualItemList = VendingMachine.readFile(source);


        // Assert
        for (int i=0;i<itemList.size();i++){
            Assert.assertEquals(itemList.get(i).getName(),actualItemList.get(i).getName());
            Assert.assertEquals(itemList.get(i).getSlotIdentifier(),actualItemList.get(i).getSlotIdentifier());
            Assert.assertEquals(itemList.get(i).getPrice(),actualItemList.get(i).getPrice());
            Assert.assertEquals(itemList.get(i).getMessage(),actualItemList.get(i).getMessage());
            Assert.assertEquals(itemList.get(i).getQuantity(),actualItemList.get(i).getQuantity());


        }
    }

        @Test
        public void test_readFile_send_in_Test1_txt_return_list () {
            // Arrange
            String source = "readFileTest1";
            List<SellableItem> itemList = new ArrayList<>();
            itemList.add(new Munchy("Cheetos", new BigDecimal("1.65"), "A1"));
            itemList.add(new Drinks("Soda", new BigDecimal("1.85"), "A2"));

            // Act
            List<SellableItem> actualItemList = VendingMachine.readFile(source);
            SellableItem[] expectedArray = itemList.toArray(new SellableItem[itemList.size()]);
            SellableItem[] actualArray = actualItemList.toArray(new SellableItem[actualItemList.size()]);

            // Assert
            for (int i=0;i<itemList.size();i++){
                Assert.assertEquals(itemList.get(i).getName(),actualItemList.get(i).getName());
                Assert.assertEquals(itemList.get(i).getSlotIdentifier(),actualItemList.get(i).getSlotIdentifier());
                Assert.assertEquals(itemList.get(i).getPrice(),actualItemList.get(i).getPrice());
                Assert.assertEquals(itemList.get(i).getMessage(),actualItemList.get(i).getMessage());
                Assert.assertEquals(itemList.get(i).getQuantity(),actualItemList.get(i).getQuantity());


            }


        }

    @Test
    public void test_readFile_send_in_Test2_txt_return_empty_list () {
        // Arrange
        String source = "readFileTest2";
        List<SellableItem> itemList = new ArrayList<>();


        // Act
        List<SellableItem> actualItemList = VendingMachine.readFile(source);

        // Assert
        for (int i=0;i<itemList.size();i++){
            Assert.assertEquals(itemList.get(i).getName(),actualItemList.get(i).getName());
            Assert.assertEquals(itemList.get(i).getSlotIdentifier(),actualItemList.get(i).getSlotIdentifier());
            Assert.assertEquals(itemList.get(i).getPrice(),actualItemList.get(i).getPrice());
            Assert.assertEquals(itemList.get(i).getMessage(),actualItemList.get(i).getMessage());
            Assert.assertEquals(itemList.get(i).getQuantity(),actualItemList.get(i).getQuantity());


        }


    }




}