package com.demo.rentalapp;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.demo.rentalapp.Models.CustomerItem;
import com.demo.rentalapp.Models.RentalAgreement;
import com.demo.rentalapp.Models.ToolBox;
import com.demo.rentalapp.Operations.Checkout;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

    /**
     * Rigorous Test :-)
     */
    @Test
    public void testAppJackhammerR1()
    {
        ToolBox.createToolBox();
        CustomerItem selectedItem = new CustomerItem("JAKR", 5, 101, "9/3/15");
        RentalAgreement testAgreement = Checkout.checkoutItem(selectedItem);
        RentalAgreement expectedAgreement = new RentalAgreement("JAKR", "Jackhammer", "Ridgid", 5, "9/3/15", "Exception", 0, 2.99, 0, 101, 0, 0);
        
        boolean expectedResult = true;
        boolean actualResult = RentalAgreement.compareAgreements(expectedAgreement, testAgreement);

        assertEquals(expectedResult, actualResult);                
    }


    @Test
    public void testAppLadder()
    {
        ToolBox.createToolBox();
        CustomerItem selectedItem = new CustomerItem("LADW", 3, 10, "7/2/20");
        RentalAgreement testAgreement = Checkout.checkoutItem(selectedItem);
        RentalAgreement expectedAgreement = new RentalAgreement("LADW", "Ladder", "Werner", 3, "7/2/20", "7/5/2020", 2, 1.99, 3.98, 10, 0.40, 3.58);
        
        boolean expectedResult = true;
        boolean actualResult = RentalAgreement.compareAgreements(expectedAgreement, testAgreement);

        assertEquals(expectedResult, actualResult);                
    }
    
    @Test
    public void testAppChainsaw()
    {
        ToolBox.createToolBox();
        CustomerItem selectedItem = new CustomerItem("CHNS", 5, 25, "7/2/15");
        RentalAgreement testAgreement = Checkout.checkoutItem(selectedItem);
        RentalAgreement expectedAgreement = new RentalAgreement("CHNS", "Chainsaw", "Stihl", 5, "7/2/15", "7/7/2015", 3, 1.49, 4.47, 25, 1.12, 3.35);
        
        boolean expectedResult = true;
        boolean actualResult = RentalAgreement.compareAgreements(expectedAgreement, testAgreement);

        assertEquals(expectedResult, actualResult);                
    }

    @Test
    public void testAppJackhammerD()
    {
        ToolBox.createToolBox();
        CustomerItem selectedItem = new CustomerItem("JAKD", 6, 0, "9/3/15");
        RentalAgreement testAgreement = Checkout.checkoutItem(selectedItem);
        RentalAgreement expectedAgreement = new RentalAgreement("JAKD", "Jackhammer", "DeWalt", 6, "9/3/15", "9/9/2015", 3, 2.99, 8.97, 0, 0, 8.97);
        
        boolean expectedResult = true;
        boolean actualResult = RentalAgreement.compareAgreements(expectedAgreement, testAgreement);

        assertEquals(expectedResult, actualResult);                
    }

    @Test
    public void testAppJackhammerR2()
    {
        ToolBox.createToolBox();
        CustomerItem selectedItem = new CustomerItem("JAKR", 9, 0, "7/2/15");
        RentalAgreement testAgreement = Checkout.checkoutItem(selectedItem);
        RentalAgreement expectedAgreement = new RentalAgreement("JAKR", "Jackhammer", "Ridgid", 9, "7/2/15", "7/11/2015", 5, 2.99, 14.95, 0, 0, 14.95);
        
        boolean expectedResult = true;
        boolean actualResult = RentalAgreement.compareAgreements(expectedAgreement, testAgreement);

        assertEquals(expectedResult, actualResult);                
    }

    @Test
    public void testAppJackhammerR3()
    {
        ToolBox.createToolBox();
        CustomerItem selectedItem = new CustomerItem("JAKR", 4, 50, "7/2/20");
        RentalAgreement testAgreement = Checkout.checkoutItem(selectedItem);
        RentalAgreement expectedAgreement = new RentalAgreement("JAKR", "Jackhammer", "Ridgid", 4, "7/2/20", "7/6/2020", 1, 2.99, 2.99, 50, 1.50, 1.49);
        
        boolean expectedResult = true;
        boolean actualResult = RentalAgreement.compareAgreements(expectedAgreement, testAgreement);

        assertEquals(expectedResult, actualResult);                
    }
}



/*
        // Get input data 
        final int rentalDays = selectedItem.getRentalDays();
        final int discount = selectedItem.getDiscount();
        final String coDateStr = selectedItem.getCheckoutDate();

        // Get the due date
        final String dueDateStr = Checkout.getDueDate(rentalDays, coDateStr);

        // Get the amount of charge days
        Tool selectedTool = Checkout.findTool(selectedItem);
        final int chargeDays = Checkout.calculateChargeDays(selectedTool, coDateStr, dueDateStr);

        // Get the total costs
        final double preDiscountCharge = selectedTool.getCost() * chargeDays;
        final double discountAmt = Math.round(preDiscountCharge * discount) / 100d;
        final double finalCharge = Math.round((preDiscountCharge - discountAmt) * 100) / 100d;

        // Add data to rental agreement
        RentalAgreement testAgreement = new RentalAgreement(
            selectedTool.getCode(),selectedTool.getType(), selectedTool.getBrand(),rentalDays,coDateStr,dueDateStr,
            chargeDays,selectedTool.getCost(),preDiscountCharge,discount,discountAmt,finalCharge);
        RentalAgreement expectedAgreement = new RentalAgreement(
            "LADW", "Ladder", "Werner", 3, "7/2/20", "7/5/2020", 2, 1.99, 3.98, 10, 0.40, 3.58);*/