package com.demo.rentalapp.Models;

import java.util.ArrayList;
import java.util.List;

/**
 * ToolBox
 */
public class ToolBox {

    static List<Tool> availableTools = new ArrayList<Tool>();

    //Rental tool variables 
    private static Tool ladder = new Tool("Ladder", "LADW", "Werner", 1.99, true, true, false);
    private static Tool chainsaw = new Tool("Chainsaw", "CHNS", "Stihl", 1.49, true, false, true);
    private static Tool jackhammerR = new Tool("Jackhammer", "JAKR", "Ridgid", 2.99, true, false, false);
    private static Tool jackhammerD = new Tool("Jackhammer", "JAKD", "DeWalt", 2.99, true, false, false);

   /**
     * Add the rental tool variables to a List object 
     * Parameters: none
     * Return: List of tools
    **/
    public static List<Tool> createToolBox() {
        availableTools.add(ladder);
        availableTools.add(chainsaw);
        availableTools.add(jackhammerR);
        availableTools.add(jackhammerD);
        return availableTools;
    }

    /**
     * Getter method for the set of added tools
     * Parameters: none
     * Return: List of tools 
    **/
    public static List<Tool> getToolBox(){
        return availableTools;
    }
}