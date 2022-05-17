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
public class Main {

    public static void main(String[] args) {

        //loop until user want to exit
        while (true) {
            //choose the base number input 
            int choice = ManageConvert.menu();

            switch (choice) {
                //convert Binary To Other Base
                case 1:
                    convertBinaryToOtherBase();
                    break;
                //convert Decimal To Other Base
                case 2:
                    convertDecimalToOtherBase();
                    break;
                //convert Hexal To Other Base
                case 3:
                    convertHexalToOtherBase();
                    break;
                //Exit
                case 4:
                    return;
            }
            System.out.println("________________________");
        }
    }

    //convert Binary To Other Base
    public static void convertBinaryToOtherBase() {
        String binaryString = GetInput.getBase(2);
        int choice = ManageConvert.displayConvert("binary", "Decimal", "Hexal");
        //display base converted
        if (choice == 1) {
            System.out.println("Decimal: " + ManageConvert.Convert(binaryString, 2, 10));
        } else {
            System.out.println("Hexal: " + ManageConvert.Convert(binaryString, 2, 16));
        }
    }

    //convert Decimal To Other Base
    public static void convertDecimalToOtherBase() {
        String decimalString = GetInput.getBase(10);
        int choice = ManageConvert.displayConvert("Decimal", "Binary", "Hexal");
        //display base converted
        if (choice == 1) {
            System.out.println("Binary:" + ManageConvert.ConverFromDecimalToOtherBase(decimalString, 2));
        } else {
            System.out.println("Hexal: " + ManageConvert.ConverFromDecimalToOtherBase(decimalString, 16));
        }
    }

    //convert Hexal To Other Base
    public static void convertHexalToOtherBase() {
        String hexalString = GetInput.getBase(16);
        int choice = ManageConvert.displayConvert("Hexal", "Binary", "Decimal");
        //display base converted
        if (choice == 1) {
            System.out.println("Binary: " + ManageConvert.Convert(hexalString, 16, 2));
        } else {
            System.out.println("Decimal: " + ManageConvert.Convert(hexalString, 16, 10));
        }
    }
}

   