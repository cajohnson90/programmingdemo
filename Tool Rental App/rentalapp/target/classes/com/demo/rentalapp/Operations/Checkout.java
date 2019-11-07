package com.demo.rentalapp.Operations;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.demo.rentalapp.Models.CustomerItem;
import com.demo.rentalapp.Models.RentalAgreement;
import com.demo.rentalapp.Models.ToolBox;
import com.demo.rentalapp.Models.Tool;

/**
 * Checkout
 */
public class Checkout {

    public static RentalAgreement checkoutItem(CustomerItem item) {

        RentalAgreement finalAgreement = null; 

        if (item == null) {
            return finalAgreement;
        }

        //  Find the specified tool
        final Tool selectedTool = findTool(item);
        if (selectedTool == null) {
            System.out.println("Error: Unable to find Tool Code for: "+item.getToolCode());
            return finalAgreement;
        }

        // Get the Rental days, Discount and Checkout Date from the CustomerItem object
        final int rentalDays = item.getRentalDays();
        final int discount = item.getDiscount();
        final String coDateStr = item.getCheckoutDate();

        // Get the due date using the numboer of rental days
        final String dueDateStr = getDueDate(rentalDays, coDateStr);

        // Get the amount of charge days
        final int chargeDays = calculateChargeDays(selectedTool, coDateStr, dueDateStr);

        // Verify the Rental days are greater than 1
        if (rentalDays <= 1) {
            System.out.println("Error: Rental days needs to be greater than 1");
            return finalAgreement;
        }
        // Verify the range of the Discount is in between 0 and 100, if left blank
        // assume zero
        if (discount >= 100 || discount < 0) {
            System.out.println("Error: Discount is in between 0 and 100");
            finalAgreement = new RentalAgreement(selectedTool.getCode(), selectedTool.getType(), selectedTool.getBrand(),
                rentalDays, coDateStr, "Exception", 0, selectedTool.getCost(), 0, 101, 0, 0);
            return finalAgreement;
        }

        final double preDiscountCharge = Math.round(selectedTool.getCost() * chargeDays * 100) / 100d;
        final double discountAmt = Math.round(preDiscountCharge * discount) / 100d;
        final double finalCharge = Math.round((preDiscountCharge - discountAmt) * 100) / 100d;

        finalAgreement = new RentalAgreement(selectedTool.getCode(), selectedTool.getType(), selectedTool.getBrand(),
                rentalDays, coDateStr, dueDateStr, chargeDays, selectedTool.getCost(), preDiscountCharge, discount,
                discountAmt, finalCharge);
        return finalAgreement;
    }

    /**
     * Calculate the number of days to charge the customer for the tool Parameters:
     * none Return: CustomerItem object
     **/
    public static int calculateChargeDays(Tool tool, String rentalDate, String dueDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
        Date startDate = new Date();
        Date endDate = new Date();

        // Convert the date string into a Date object
        try {
            startDate = sdf.parse(rentalDate);
            endDate = sdf.parse(dueDate);
        } catch (Exception e) {
        }

        // Start date
        Calendar start = Calendar.getInstance();
        start.setTime(startDate);
        start.add(Calendar.DATE, 1);

        // End date
        Calendar end = Calendar.getInstance();
        end.setTime(endDate);
        end.add(Calendar.DATE, 1);

        // Charge day counter
        int chargeDayCounter = 0;

        // Get the charge day attributes for the specified tool
        boolean chargeWeekdayBool = tool.getWeekdayCharge();
        boolean chargeHolidayBool = tool.getHolidayCharge();
        boolean chargeWeekendBool = tool.getWeekendCharge();

        // Iterate thru the days to determine which days are charged
        for (start.getTime(); start.before(end); start.add(Calendar.DATE, 1), start.getTime()) {
            if (((start.get(Calendar.MONTH) + 1) == 7
                    && (start.get(Calendar.DAY_OF_MONTH) == 3 && start.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY)
                    || (start.get(Calendar.DAY_OF_MONTH) == 5 && start.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY))
                    || (start.get(Calendar.MONTH) + 1) == 9 && start.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY
                            && start.get(Calendar.DAY_OF_MONTH) <= 7) {
                if (chargeHolidayBool) {
                    chargeDayCounter++;
                }
            } else if ((start.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY
                    || start.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) && chargeWeekendBool) {
                chargeDayCounter++;
            } else if (start.get(Calendar.DAY_OF_WEEK) != 1 && start.get(Calendar.DAY_OF_WEEK) != 7
                    && chargeWeekdayBool) {
                chargeDayCounter++;
            }
        }
        return chargeDayCounter;
    }

    /**
     * Calculates the due date for tool Parameters: Int - number of rental days,
     * String - checkout date Return: String for the due
     **/
    public static String getDueDate(int rentalDays, String coDateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
        Date coDate = new Date();
        try {
            coDate = sdf.parse(coDateStr);
        } catch (Exception e) {}

        Calendar cal = Calendar.getInstance();
        cal.setTime(coDate);
        cal.add(Calendar.DATE, rentalDays);

        String dueDate = String.valueOf(cal.get(Calendar.MONTH) + 1)+"/"+
            String.valueOf(cal.get(Calendar.DAY_OF_MONTH))+"/"+cal.get(Calendar.YEAR);
        return dueDate;
    }

    /**
     * Iterate thru the available tools and compare the user tool code against the toolbox codes
     * Parameters: CustomerItem - user input attributes
     * Return: Tool object 
    **/
    public static Tool findTool(CustomerItem item){
        Tool foundtool = null;
        String userToolCode = item.getToolCode();

        if(userToolCode == null || userToolCode.length() == 0){
            return foundtool;
        }
        List<Tool> toolbox = ToolBox.getToolBox();
        String toolCode; 

        for(Tool tool : toolbox){
            toolCode = tool.getCode();
            if(toolCode.equals(userToolCode)){
                foundtool = tool;
                break;
            }
        }
        return foundtool;        
    }

}