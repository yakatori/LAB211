/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package T21_20loc_CompareDate103;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class CompareDate {

    public static void main(String[] args) {
        //Step1: Enter the first date
        Date firstDate = getDate("Please enter the first date: ");

        //Step1: Enter the second date
        Date secondDate = getDate("Please enter the second date: ");
        System.out.println();
        
        //Step3: Compare and display
        compareDate(firstDate, secondDate);
    }

    //Get date format
    public static Date getDate(String msg) {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
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
                    return date;
                } catch (ParseException e) {
                    System.out.println("Invailded date! Re-enter!!!");
                }
            }
        }
    }

    //Compare date
    public static void compareDate(Date firstDate, Date secondDate) {
        //compare first date and second date
        if (firstDate.before(secondDate)) {
            System.out.println("Date1 is before Date2");
        } else if (firstDate.after(secondDate)) {
            System.out.println("Date1 is after Date2");
        } else {
            System.out.println("Date1 is equal Date2");
        }
    }
}
