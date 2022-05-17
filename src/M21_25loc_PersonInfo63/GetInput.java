/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package M21_25loc_PersonInfo63;

import java.util.Scanner;

/**
 *
 * @author admin
 */
public class GetInput {

    //Get integer number
    public static int getInt(int min, int max) {
        Scanner sc = new Scanner(System.in);
        //Loop to check input until it falses 
        while (true) {
            System.out.println("Enter number of array: ");

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
                System.out.println("Invalid. Please press enter to try again");
            }
        }
    }

    public static double getDouble(String message, String error, double min, double max) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine();
            try {
                double number = Double.parseDouble(input);
                //if input is empty then tell user
                if (input.isEmpty()) {
                    System.out.println("Input cannot be empty !!!");
                }
                if (number < 0) {
                    System.out.println("Salary is greater than zero");
                } else if (number >= min && number <= max) {
                    return number;
                } else {
                    System.out.println("The number must be in range "
                            + min + " to " + max);
                }

            } catch (Exception e) {
                System.out.println(error);
            }
        }
    }

    public static float getFloat(String message, String error, double min, double max) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            //input
            System.out.println(message);
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                System.out.println("Input cant empty!!");
            }
            try {
                float number = Float.parseFloat(input);
                if (number >= min && number <= max) {
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

    public static String getString(String msg, String error, String regex) {
        Scanner scanner = new Scanner(System.in);

        //check input until get string format
        while (true) {
            System.out.print(msg);
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("String input cant empty");
            } //check format string
            else {
                if (input.matches(regex)) {
                    return input;
                } else {
                    System.out.println(error);
                }
            }
        }
    }

}
