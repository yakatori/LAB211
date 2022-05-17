/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package I21_69loc_ManageCountries52;

import java.util.Scanner;

/**
 *
 * @author admin
 */
public class GetInput {

    /* regex:
                [a-zA-Z0-9 ]+: must characters a-z, A-Z, number 0-9 and space                   
    */
    public static final String REGEX_NAME = "[a-zA-Z0-9 ]+";

    //Get integer number
    public static int getInt(String msg, String error,int min, int max) {
        Scanner sc = new Scanner(System.in);
        //Loop to check input until it falses 
        while (true) {
            System.out.println(msg);

            try {
                int number = Integer.parseInt(sc.nextLine().trim());
                if (min <= number && number <= max) {
                    //If the number is true then return, else tell user press enter to input again                   
                    return number;
                } else {
                    System.out.println("The number must be in range "
                            + min + " to " + max);
                }
            } catch (NumberFormatException e) {
                System.out.println(error);
            }
        }
    }

    public static float getFloat(String message, String error, float min, float max) {
        Scanner scanner = new Scanner(System.in);
        //loop until enter right format float number
        while (true) {
            try {
                System.out.print(message);
                String input = scanner.nextLine().trim();
                //if input is empty then tell user
                if (input.isEmpty()) {
                    System.out.println("Input cannot be empty! Re-enter!!!");
                } //else input has float number 
                else {
                    float number = Float.parseFloat(input);
                    //if number in range then return number
                    if (min <= number && number <= max) {
                        return number;
                    } //else tell user re-enter
                    else {
                        System.out.println("Area must greater than 0! Re-enter!!!");
                    }

                }
            } catch (NumberFormatException e) {
                System.out.println(error);
            }
        }

    }

    public static String getString(String message, String error, String regex) {
        Scanner scanner = new Scanner(System.in);
        //loop until enter right format string
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();
            //if input empty then tell user 
            if (input.isEmpty()) {
                System.out.println("Input cannot be empty !!!");
            } //else input has right format string
            else {
                //if input matches with regex then return input
                if (input.matches(regex)) {
                    return input;
                } else {
                    System.out.println(error);
                }
            }
        }
    }
}
