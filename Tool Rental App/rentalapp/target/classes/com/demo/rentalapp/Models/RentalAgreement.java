package com.demo.rentalapp.Models;

/**
 * Rental Aggrement
 */
public class RentalAgreement {

    private String toolCode;
    private String toolType;
    private String toolBrand;
    private int rentalDays; 
    private String checkoutDate;
    private String dueDate;
    private double toolCharge;
    private int chargeDays;
    private double preDiscountCharge;
    private int discount;
    private double discountAmt;
    private double finalCharge;

    public RentalAgreement(String toolCode, String toolType, String toolBrand, int rentalDays, String checkoutDate, String dueDate, int chargeDays, double toolCharge,
            double preDiscountCharge, int discount, double discountAmt, double finalCharge) {
        this.toolCode = toolCode;
        this.toolType = toolType;
        this.toolBrand = toolBrand;
        this.rentalDays = rentalDays;
        this.checkoutDate = checkoutDate;
        this.dueDate = dueDate;
        this.chargeDays = chargeDays;
        this.toolCharge = toolCharge;
        this.preDiscountCharge = preDiscountCharge;
        this.discount = discount;
        this.discountAmt = discountAmt;
        this.finalCharge = finalCharge;
    }

    public String getToolCode() {
        return toolCode;
    }

    public void setToolCode(String toolCode) {
        this.toolCode = toolCode;
    }

    public String getToolType() {
        return toolType;
    }

    public void setToolType(String toolType) {
        this.toolType = toolType;
    }

    public String getToolBrand() {
        return toolBrand;
    }

    public void setToolBrand(String toolBrand) {
        this.toolBrand = toolBrand;
    }

    public int getRentalDays() {
        return rentalDays;
    }

    public void setRentalDays(int rentalDays) {
        this.rentalDays = rentalDays;
    }

    public double getToolCharge() {
        return toolCharge;
    }

    public void setToolCharge(double toolCharge) {
        this.toolCharge = toolCharge;
    }

    public double getPreDiscountCharge() {
        return preDiscountCharge;
    }

    public void setPreDiscountCharge(double preDiscountCharge) {
        this.preDiscountCharge = preDiscountCharge;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public double getDiscountAmt() {
        return discountAmt;
    }

    public void setDiscountAmt(double discountAmt) {
        this.discountAmt = discountAmt;
    }

    public double getFinalCharge() {
        return finalCharge;
    }

    public void setFinalCharge(double finalCharge) {
        this.finalCharge = finalCharge;
    }

    public String getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(String checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public int getChargeDays() {
        return chargeDays;
    }

    public void setChargeDays(int chargeDays) {
        this.chargeDays = chargeDays;
    }

    public static boolean compareAgreements(RentalAgreement expected, RentalAgreement actual){
        boolean result = true;
        
        if(!expected.getToolCode().equals(actual.getToolCode())){
            result = false;
        }else if(!expected.getToolType().equals(actual.getToolType())){
            result = false;
        }else if(!expected.getToolBrand().equals(actual.getToolBrand())){
            result = false;
        }else if(expected.getRentalDays() != (actual.getRentalDays())){
            result = false;
        }else if(!expected.getCheckoutDate().equals(actual.getCheckoutDate())){
            result = false;
        }else if(!expected.getDueDate().equals(actual.getDueDate())){
            result = false;
        }else if(expected.getChargeDays() != (actual.getChargeDays())){
            result = false;
        }else if(expected.getToolCharge() != (actual.getToolCharge())){
            result = false;
        }else if(expected.getPreDiscountCharge() != (actual.getPreDiscountCharge())){
            System.out.println(expected.getPreDiscountCharge() +"||"+actual.getPreDiscountCharge());
            result = false;
        }else if(expected.getDiscount() != (actual.getDiscount())){
            result = false;
        }else if(expected.getDiscountAmt() != (actual.getDiscountAmt())){
            result = false;
        }else if(expected.getFinalCharge() != (actual.getFinalCharge())){
            result = false;
        }    
        return result;
    }    
}