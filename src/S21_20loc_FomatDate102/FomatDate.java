/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package S21_20loc_FomatDate102;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class FomatDate {

    public static void main(String[] args) {

        //Step1: Enter date with [dd/mm/yyyy] format 
        String date = getDate("Please enter date with format [dd/mm/yyyy]: ");

        //Step2: Check input date exist
        if (isValidDate(date) == true) {

            //Step3: Determine day of week with input date
            determineDayOfWeek(date);
        }
    }

    public static String getDate(String msg) {
        /*regex:
                d{1,2}: decimal with 1 or 2 number (day)               
                d{1,2}: decimal with 1 or 2 number (month)
                d{1,4}: decimal with 4 number (year)
                [/]   : character '/' 
         */
        String REGEX_DATE = "\\d{1,2}[/]\\d{1,2}[/]\\d{4}";
        Scanner scanner = new Scanner(System.in);
        String date;
        // loop until true data format
        while (true) {
            System.out.print(msg);
            date = scanner.nextLine().trim();
            if (date.isEmpty()) {
                System.out.println("Input can not empty");
            } else {
                if (!date.matches(REGEX_DATE)) {
                    System.out.println("Invail date! Re-enter!!!");

                } else {
                    if (isValidDate(date)) {
                        return date;
                    } else {
                        System.out.println("Date doesn't exist! Re-enter!!!");
                    }
                }
            }

        }

    }

    public static boolean isValidDate(String date) {

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            dateFormat.setLenient(false);
            dateFormat.parse(date);
        } catch (ParseException e) {
            return false;
        }

        return true;
    }

    public static void determineDayOfWeek(String inputDate) {
        try {
            SimpleDateFormat dateFormatFull = new SimpleDateFormat("dd/MM/yyyy");
            Date date = dateFormatFull.parse(inputDate);

            SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE");
            String dayOfWeek = dateFormat.format(date);
            System.out.println("Your day is " + dayOfWeek);
        } catch (ParseException ex) {
            System.out.println("Date does not exist");
        }
    }
}
