/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package H21_100loc_ConvertBase11;

import java.util.Scanner;

/**
 *
 * @author admin
 */
public class GetInput {

    public static String getBase(int base) {
        Scanner sc = new Scanner(System.in);
        String Base = "0123456789ABCDEF";
        String check = "[" + Base.substring(0, base) + "]+";
        //loop until enter true format input base
        do {
            System.out.println("Input value: ");
            String stringInput = sc.nextLine().toUpperCase().trim();
            if (stringInput.matches(check)) {
                return stringInput;
            }
            System.err.println("Input digit in range: 0- " + (base - 1) + "! ");
            System.out.println("Input again:");
        } while (true);
    }

    public static int getInputIntLimit(int min, int max) {
        Scanner sc = new Scanner(System.in);
        //loop untill enter true int value
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input integer number in rage [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }

}
