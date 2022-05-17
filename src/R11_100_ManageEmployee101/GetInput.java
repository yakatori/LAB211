/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package R11_100_ManageEmployee101;

/**
 *
 * @author admin
 */
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class GetInput {

    /*
         regex:
                a-z: matches character from a-z
                A-Z: matches character from A-Z
                   : matches with SPACE
                +  : matches the previous token between one and unlimited times
                0-9: matches with digit from 0-9
                .  : matches with character .
                /  : matches with character /
                [@]: must have character @
              {1,2}: must have 1 or 2 character
     */
    public static final String REGEX_NAME = "[a-zA-Z]+";
    public static final String REGEX_ADDRESS = "[a-zA-Z0-9 ]+";
    public static final String REGEX_PHONE = "[0][0-9]{9,10}";
    public static final String REGEX_EMAIL = "[a-zA-Z0-9]+[@]([a-zA-Z]+[.]){1,2}[a-zA-Z]+";
    public static final String REGEX_YN = "[yYnN]";

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

    public static String getDate(String msg) {
        Scanner scanner = new Scanner(System.in);
        Date dateTime = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String currentDate = dateFormat.format(dateTime);
        String date;
        while (true) {
            System.out.print(msg);
            date = scanner.nextLine().trim();

            boolean dateLessThanCurrentDate = checkDate1BeforeDate2(date, currentDate);
            //dateLessThanCurrentDate return true => date input < date current 
            //else date input > date current

            if (date.isEmpty()) {
                System.out.println("Input can't be empty");
            } else if (isValidDate(date) == false) {
                System.out.println("The date does not exist !!!");
            } else if (dateLessThanCurrentDate == false) {
                System.out.println("Date must be less than " + currentDate);
            } else {
                return date;
            }

        }

    }

    public static boolean isValidDate(String date) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dateTest = null;
        dateFormat.setLenient(false);

        try {
            dateTest = dateFormat.parse(date);
            return true;
        } catch (ParseException ex) {
            return false;
        }
    }

    private static boolean checkDate1BeforeDate2(String dateInput, String currentDate) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date firstDate;
        Date secondDate;

        try {
            firstDate = dateFormat.parse(dateInput);
            secondDate = dateFormat.parse(currentDate);

            //if first date before second date => return true
            //if first date after second date => return false
            //if first date equal second date = > return false
            if (firstDate.before(secondDate)) {
                return true;
            } else {
                return false;
            }

        } catch (ParseException ex) {
            return false;
        }
    }

    public static boolean checkWantToUpdate(String message) {
        String test = getString("Do you want to update " + message + " ?: ", "It must be Y or N", REGEX_YN);
        if (test.equalsIgnoreCase("y")) {
            return true;
        }
        return false;
    }

    public static int getID() {
        int id = GetInput.getInt("Enter id: ", "It must be digit", 0, Integer.MAX_VALUE);
        return id;
    }

    public static String getFirstName() {
        String firstName = GetInput.getString("Enter first name: ", "Wrong format", GetInput.REGEX_NAME);
        return firstName;
    }

    public static String getLastName() {
        String lastName = GetInput.getString("Enter last name: ", "Wrong format", GetInput.REGEX_NAME);
        return lastName;
    }

    public static String getPhone() {
        String phone = GetInput.getString("Enter phone(must have 10 digits and start with 0):\n ", "Wrong format", GetInput.REGEX_PHONE);
        return phone;
    }

    public static String getEmail() {

        String email = GetInput.getString("Enter mail: ", "Wrong format", GetInput.REGEX_EMAIL);

        return email;

    }

    public static String getAddress() {
        String address = GetInput.getString("Enter address: ", "Wrong format", GetInput.REGEX_ADDRESS);
        return address;
    }

    public static String getDOB() {
        String dob = GetInput.getDate("Enter date in format (dd/MM/yyyy): ");
        return dob;
    }

    public static int getSex() {
        int sex = GetInput.getInt("Enter sex (1: male || 0: female )", "(1: male || 0: female )", 0, 1);
        return sex;
    }

    public static double getSalary() {
        double salary = GetInput.getDouble("Enter salary: ", "Wrong format", 0, Double.MAX_VALUE);
        return salary;
    }

    public static String getAgency() {
        String agency = GetInput.getString("Enter agency: ", "Wrong format", GetInput.REGEX_NAME);
        return agency;
    }

}
