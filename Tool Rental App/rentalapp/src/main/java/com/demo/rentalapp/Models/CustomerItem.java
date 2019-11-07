package com.demo.rentalapp.Models;

/**
 * CustomerItem
 */
public class CustomerItem {

    private String toolCode;
    private int rentalDays;
    private int discount;
    private String checkoutDate;

    public CustomerItem(String toolCode, int rentalDays, int discount, String checkoutDate) {
        this.toolCode = toolCode;
        this.rentalDays = rentalDays;
        this.discount = discount;
        this.checkoutDate = checkoutDate;
    }

    public String getToolCode() {
        return toolCode;
    }

    public void setToolCode(String toolCode) {
        this.toolCode = toolCode;
    }

    public int getRentalDays() {
        return rentalDays;
    }

    public void setRentalDays(int rentalDays) {
        this.rentalDays = rentalDays;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(String checkoutDate) {
        this.checkoutDate = checkoutDate;
    }   
}