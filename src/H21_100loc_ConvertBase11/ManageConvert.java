/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package H21_100loc_ConvertBase11;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class ManageConvert {

    public static int menu() {
        System.out.println("1. Convert From Binary ");
        System.out.println("2. Convert From Decimal ");
        System.out.println("3. Convert From Hexa ");
        System.out.println("(hexDigits = \"0123456789ABCDEF\" with A-F as 10-15))");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
        int choice = GetInput.getInputIntLimit(1, 4);
        return choice;
    }

    public static int displayConvert(String from, String toCase1, String toCase2) {
        System.out.println("1. Convert from " + from + " to " + toCase1);
        System.out.println("2. Convert from " + from + " to " + toCase2);
        System.out.print("Enter your choice: ");
        int result = GetInput.getInputIntLimit(1, 2);
        return result;
    }

    public static String Convert(String input, int baseFrom, int baseTo) {
        return ConverFromDecimalToOtherBase(ConverToDecimal(input, baseFrom), baseTo);
    }

    public static String ConverToDecimal(String input, int base) {
        String hexDigits = "0123456789ABCDEF";
        Scanner sc = new Scanner(System.in);
        BigInteger baseValue = BigInteger.valueOf(base);
        BigInteger result = new BigInteger("0");
        //loop run from first to last of character of input
        for (int i = 0; i < input.length(); i++) {
            BigInteger valueAtIndex = BigInteger.valueOf(hexDigits.indexOf(input.charAt(i)));
            BigInteger value = valueAtIndex.multiply(baseValue.pow(input.length() - i - 1));
            result = result.add(value);
        }
        String numberResult = result.toString();
        return numberResult;
    }

    public static String ConverFromDecimalToOtherBase(String input, int base) {
        String hexDigits = "0123456789ABCDEF";
        Scanner sc = new Scanner(System.in);
        BigInteger inputValue = new BigInteger(input);
        BigInteger baseValue = BigInteger.valueOf(base);
        String result = "";
        //loop until decimal number equal 0
        while (inputValue.compareTo(new BigInteger("0")) > 0) {
            int remainder = (inputValue.mod(baseValue).intValue());
            result = hexDigits.charAt(remainder) + result + "";
            inputValue = inputValue.divide(baseValue);
        }
        return result;
    }

}
