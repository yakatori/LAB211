/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package T21_20loc_CompareDate103;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Main {

    private static final Scanner sc = new Scanner(System.in);

    public static boolean checkfile(String file) {
        File f = new File(file);
        if (f.isFile()) {
            if (f.exists()) {
                return true;
            } else {
                System.out.println("file not exit");
                return false;
            }
        } else {
            System.out.println("Can't find file");
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        String check;
        while (true) {
            System.out.println("input path file:");
            check = sc.nextLine().trim();
            if (!check.isEmpty()) {
                break;
            }
        }
        if (checkfile(check)) {
            File file = new File(check);
            Scanner myReader = new Scanner(file);
            String str = "";
            while (myReader.hasNextLine()) {
                str = myReader.nextLine();
            }
            String[] a = str.split(" ");

            System.out.println(a);

            System.out.println("input the word need find: ");
            String find = sc.nextLine();
            for (String string : a) {
                System.out.println(string);
                if (string.contains(find)) {
                    System.out.println(string);
                }

            }

            myReader.close();
        } else {
            System.out.println("can't read file");
        }
    }

}
