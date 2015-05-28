/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ams.other;

import ams.frontEndGUI;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author kieranross
 */
public abstract class Utilities {
    
    //Is the string empty
    /**
     * Checks to see if string is empty
     * @param stringToCheck
     * @return True if string is empty
     */
        public static boolean isEmptyString(String stringToCheck){
        return stringToCheck.length() ==0;
    }
    
     //Convert String to an Int
        
    /**
     * Converts String to Int
     * @param number
     * @return 
     */            
        public static int convertStringToInt(String number){
            
            return Integer.parseInt(number);
        }
        
        public static Double convertStringToDouble(String number){
            
            return Double.parseDouble(number);
        }
        
        //Convert Int to String
       
     /**
     * Converts Int to String
     * @param number
     * @return 
     */ 
        public static String convertIntToString(int number){
            
            return Integer.toString(number);
        }
        
        public static String convertDoubleToString(double number){
            
            return Double.toString(number);
        }
        
        //Convert Boolean to String
     /**
     * Converts Boolean to String
     * @param bool
     * @return Boolean as a string
     */   
        public static String convertBooleanToString(boolean bool){
            String result;
            
            if (bool) {
                result = "True";
            } else{
                result = "False";
            }
            return result;
        }
     
        
        //Check to see if String is an integer

    /**
     * Check to see if string is an integer
     * @param s
     * @return true if an integer
     */
        public static boolean isInteger(String s) {
        try { 
            Integer.parseInt(s); 
        } catch(NumberFormatException e) { 
            return false; 
        }    
            return true;
        }
        
        //Formats double to 2 decimal places
        
     /**
     * Formats Double to 2 decimal places
     * @param doubleIn Double to format
     * @return String of formatted double
     */   
        public static String twoDecimalPlaces(double doubleIn){
        
        DecimalFormat df = new DecimalFormat("#.##"); 
        return df.format(doubleIn);
        }
        
        
        
        //Compares Strings to see if they are the same, returns boolean
        
     /**
     * Checks to see if String is equal to another string
     * @param string1 string2 Compares string1 to string2
     * @param string2
     * @return Boolean True if they are equal
     */   
        public static boolean isStringEqualTo(String string1, String string2){
            return string1.equalsIgnoreCase(string2);
        }
        
        
        //Displays Message to console
        
     /**
     * Outputs message to Console 
     * @param message Message to Display
     */ 
        public static void consoleMessage(String message){
            System.out.println(message);
        }
        
        //Display Test Message to Console
        
     /**
     * Outputs a test message to Console 
     */ 
        public static void consoleTest(){
            System.out.println("Console Test");
        }
        
       
        
        
        
}
