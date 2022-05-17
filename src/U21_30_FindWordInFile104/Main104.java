/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package U21_30_FindWordInFile104;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Main104 {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        //Step1: User input directory of file
        File fileName = getFileName("Please enter directory of file: ");
        //Step2: User input string to search
        String searchString = getSearchString("Please enter string to search: ");
        //Step3: Find string or letter words that contain the input string
        findWordInFile(fileName, searchString);

    }


    public static File getFileName(String msg) throws FileNotFoundException {

        Scanner keyboard = new Scanner(System.in);
        String filePath;
        File loadedFile = null;
        //This loop only breaks if all conditions are met.
        while (true) {
            System.out.print("Please enter directory of file:  ");
            filePath = keyboard.nextLine();

            //Try to load the file.
            loadedFile = new File(filePath);

            //Check if the entered String is empty.
            if (filePath.isEmpty()) {
                System.out.println("The path should not be empty.");
                continue;
            } //Check if the path exists
            else if (loadedFile.exists() == false) {
                System.out.println("This path does not exist.");
                continue;
            } //Check if the path is a Directory
            else if (loadedFile.isDirectory() == true) {
                System.out.println("This path lead to a folder, not a file.");
                continue;
            } //If all conditions are met, break.
            else {
                break;
            }
        }
        return loadedFile;

    }

    public static String getSearchString(String msgString) {
        /*
         regex:
                a-z: matches character from a-z
                A-Z: matches character from A-Z
                +  : matches the previous token between one and unlimited times
                0-9: matches digits 0-9
         */
        String regexString = "[a-zA-Z0-9]+";
        Scanner scanner = new Scanner(System.in);
        // ask user until true input
        while (true) {
            System.out.print(msgString);
            String string = scanner.nextLine().trim();
            if (string.isEmpty()) {
                System.out.println("Input can not be empty!!!");
            } // Check the value of user enter is match with the regex?
            // if true then return the string  
            else if (string.matches(regexString)) {
                return string;
            } else {
                System.out.println("It must be string!!!");
            }
        }

    }

    public static void findWordInFile(File fileName, String findString) throws FileNotFoundException {
        //check fileName is file, true-> find word in file

        Scanner myReader = new Scanner(fileName);
        System.out.println("\nSearch results:");
        boolean hasRead = false;
        //read file line by line
        while (myReader.hasNextLine()) {
            String w = myReader.nextLine();
            String[] a = w.split(" ");
            //loop run from first to last element of String a
            for (String string : a) {
                if (string.contains(findString)) {
                    hasRead= true;
                    System.out.println("\t" + string);
                } 
            }

        }
        myReader.close();
        if (hasRead == true) {
            System.out.println("\t...");
        } else {
            System.out.println("Can not find word in file!!");
        }

    }
}
