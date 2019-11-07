package com.demo.rentalapp.Models;

import java.util.List;

/**
 * Tool
 */
public class Tool {

    private String type;
    private String code;
    private String brand;
    private double cost;
    private boolean weekdayCharge;
    private boolean holidayCharge;
    private boolean weekendCharge;

    public Tool(String type, String code, String brand, double cost, boolean weekdayCharge, boolean weekendCharge, boolean holidayCharge) {
        this.type = type;
        this.code = code;
        this.cost = cost;
        this.brand = brand;
        this.weekdayCharge = weekdayCharge;
        this.holidayCharge = holidayCharge;
        this.weekendCharge = weekendCharge;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public boolean getWeekdayCharge() {
        return weekdayCharge;
    }

    public void setWeekdayCharge(boolean weekdayCharge) {
        this.weekdayCharge = weekdayCharge;
    }

    public boolean getHolidayCharge() {
        return holidayCharge;
    }

    public void setHolidayCharge(boolean holidayCharge) {
        this.holidayCharge = holidayCharge;
    }

    public boolean getWeekendCharge() {
        return weekendCharge;
    }

    public void setWeekendCharge(boolean weekendCharge) {
        this.weekendCharge = weekendCharge;
    }

	public static List<Tool> createToolBox() {
		return null;
	}

    
}