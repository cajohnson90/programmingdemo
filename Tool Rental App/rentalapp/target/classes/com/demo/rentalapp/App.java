package com.demo.rentalapp;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import com.demo.rentalapp.Models.CustomerItem;
import com.demo.rentalapp.Models.RentalAgreement;
import com.demo.rentalapp.Models.Tool;
import com.demo.rentalapp.Models.ToolBox;
import com.demo.rentalapp.Operations.Checkout;

/**
 * POS
 */
public class App {

    public static void main(String[] args) {
        
        //Call the create Tool function which will add a set of tools into a list object
        List<Tool> toolbox = ToolBox.createToolBox();

        //Create a instance of a Point of Sale object
        App pointOfSale = new App();

        //Print the tool data to the console for the user
        pointOfSale.printToolInfo(toolbox);

        //Capture the user input and save the data in a CustomerItem object
        CustomerItem selectedItem = pointOfSale.promptUser();

        //Use a Checkout object to calculate cost of rental tool and return a Retal agreement object
        RentalAgreement agreement = Checkout.checkoutItem(selectedItem);

        //Print the retail agreement data to the console
        pointOfSale.printAgreement(agreement);
    }

    /**
     * Prints the tool data to the console
     * Parameters: List of tools 
     * Return: void
    **/
    public void printToolInfo(List<Tool> availableTools){
        System.out.println("*** Tools ***");
        if(availableTools == null){
            System.out.println("No tools are available");
        }
        for(Tool tool : availableTools){
            System.out.println(
                "Type:" + tool.getType() +" "+ 
                "Brand:" + tool.getBrand() +" "+  
                "Code:" + tool.getCode() +" "+  
                "Cost:" + tool.getCost() +" "+  
                "Weekends:" + tool.getWeekendCharge() +" "+  
                "Holdays:" + tool.getHolidayCharge()
            );
        }
    }

    /**
     * Prompts the user to input a tool code, the number of rental days, a discount and a checkout date
     * Parameters: none
     * Return: CustomerItem object
    **/
    public CustomerItem promptUser(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Tool code:");
        String toolCode = scanner.nextLine().toUpperCase();
        System.out.println("Enter amount of Rental Days:");
        int rentalDays = 0;
        while(rentalDays == 0){
            try { 
                rentalDays = Integer.parseInt(scanner.nextLine());
            } catch(NumberFormatException e) { 
                System.out.println("Please try again - Enter the number of Rental Days:");
            }
        }
        int discount = -1;
        System.out.println("Enter the Discount:");
        while(discount == -1){
            try { 
                discount = Integer.parseInt(scanner.nextLine());
            } catch(NumberFormatException e) { 
                System.out.println("Please try again - Enter a whole Discount number:");
            }
        }
        String dateString = "";
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
        boolean validDateBool = false;
        System.out.println("Enter Checkout Date (mm/dd/yy):");
        while(validDateBool == false){
            dateString = scanner.nextLine();
            try{
                if(dateString.equals("quit")){
                    dateString = "00/00/00";
                    break;
                }
                sdf.parse(dateString);
                validDateBool = true;
            }catch(Exception e)
            {   
                System.out.println("Please try again - " + dateString+" is not a valid Date or type 'quit'");
            }
            
        }
        
        scanner.close();
        CustomerItem customerItem = new CustomerItem(toolCode, rentalDays, discount, dateString);
        return customerItem;
    }

    /**
     * Prints the properties in the Rental Agreement
     * Parameters: Rental Agreement object
     * Return: void
    **/
    public void printAgreement(RentalAgreement agreement){
        if(agreement == null){
            System.out.println("Rental agreement not created!");
        } else {
            System.out.println(
                "Tool code: " + agreement.getToolCode() +"\n"+  
                "Tool type: " + agreement.getToolType() +"\n"+  
                "Tool brand: " + agreement.getToolBrand() +"\n"+    
                "Rental days: " + agreement.getRentalDays() +"\n"+
                "Check out date: " + agreement.getCheckoutDate() +"\n"+  
                "Due Date: " + agreement.getDueDate()+"\n"+  
                "Daily rental charge: " + agreement.getToolCharge() +"\n"+  
                "Charge days: " + agreement.getChargeDays() +"\n"+  
                "Pre-discount rental charge: " + agreement.getPreDiscountCharge() +"\n"+  
                "Discount percent: " + agreement.getDiscount() +"\n"+
                "Discount amount: " + agreement.getDiscountAmt() +"\n"+
                "Final Charge: " + agreement.getFinalCharge()
            );
        }
    }
}