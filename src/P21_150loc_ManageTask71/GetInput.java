/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P21_150loc_ManageTask71;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    public static int getInt(String msgString, String errorString,
            int min, int max) {
        Scanner scanner = new Scanner(System.in);

        // ask user until true input
        while (true) {
            System.out.print(msgString);
            try {
                String input = scanner.nextLine().trim();
                //if input is empty or have only space => tell user
                if (input.isEmpty()) {
                    System.out.println("Input can't be empty!!!");
                } else {
                    int number = Integer.parseInt(input);
                    // check the range of input
                    if (min <= number && number <= max) {
                        return number;
                    } else {
                        System.out.println("Invalid. The input must be "
                                + "in range " + min + " to " + max);
                    }
                }

            } catch (NumberFormatException e) {
                System.out.println(errorString);
            }
        }

    }

    public static String getString(String msgString, String error, String regexString) {
        Scanner scanner = new Scanner(System.in);
        // ask user until true input
        while (true) {
            System.out.print(msgString);
            String string = scanner.nextLine().trim();
            if (string.isEmpty()) {
                System.out.println("Input can't be empty!!!");
            } // Check the value of user enter is match with the regex?
            // if true then return the string  
            else if (string.matches(regexString)) {

                return string;
            } else {
                System.out.println(error);
            }
        }

    }

    public static double getDouble(String msgString, String error, double d, double f) {
        Scanner scanner = new Scanner(System.in);
        // ask user until true input
        while (true) {
            System.out.print(msgString);
            try {
                String input = scanner.nextLine().trim();
                //if input is empty or have only space => tell user
                if (input.isEmpty()) {
                    System.out.println("Input can't be empty!!!");
                } else {
                    double floatInput = Double.parseDouble(input);
                    //if floatInput not divide to 0.5 then tell user
                    if (floatInput % 0.5 != 0) {
                        System.out.println("It must be divide to 0.5");
                    } // check the range of input
                    else if (d <= floatInput && floatInput <= f) {
                        return floatInput;
                    } else {
                        System.out.println("Invalid. The input must be in range "
                                + d + " to " + f);
                    }
                }

            } catch (NumberFormatException e) {
                System.out.println(error);
            }
        }
    }

    //Get date format
    public static String getDate(String msg, String error) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date dateTime = new Date();
        String currentDate = dateFormat.format(dateTime);
        Date date = new Date();
        Date today = new Date();
        today = dateFormat.parse(currentDate);
        dateFormat.setLenient(false);
        // loop until true data format
        while (true) {
            System.out.print(msg);
            String dateString = sc.nextLine();
            if (dateString.isEmpty()) {
                System.out.println("Input can not empty!");
            } else {
                try {
                    date = dateFormat.parse(dateString);
                    //if checkCompareDate true=> date invalid
                    if (checkCompareDate(date, today) == true) {
                        System.out.println("Date must be equal or greater than " + currentDate);
                    } else {
                        return dateString;
                    }

                } catch (ParseException e) {
                    System.out.println(error);
                }
            }
        }
    }

    //check compare date
    public static boolean checkCompareDate(Date firstDate, Date secondDate) {
        //compare first date and second date
        //if first date before second date => return true
        if (firstDate.before(secondDate)) {
            return true;
        } else {
            return false;
        }
    }
}
