/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package T21_20loc_CompareDate103;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class demo {

    public static void main(String[] args) throws FileNotFoundException {
        //Enter the directory string from keyboard and load the file
        File loadedFile = enterAndLoad_File();
        //Enter string for searching in loaded file
        String keyString = inputString();
        //Search for strings that contain input string
        findString(loadedFile, keyString);
    }
    
    private static File enterAndLoad_File() {
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

    private static String inputString() {
        Scanner keyboard = new Scanner(System.in);
        String keyString = "";
        //This loop only breaks if the string is not empty
        while (true) {
            System.out.print("Please enter string to search: ");
            keyString = keyboard.nextLine();
            //Check if the keyString is empty.
            if (keyString.isEmpty()) {
                System.out.println("The string must not be empty. Try again.");
            }
            //If the above conditions aren't met, the string must be correct.
            else {
                break;
            }

        }
        return keyString;
    }

    private static void findString(File loadedFile, String keyString) {
        try {
            Scanner reader = new Scanner(loadedFile);
            boolean hasResult = false;
            
            System.out.println("\nSearch results:");
            
            //Access each line of the text file
            while (reader.hasNextLine()) {
                String readingLine = reader.nextLine();
                //List for storing all the indexes where the keyString is found on current line
                List<Integer> indexList = new ArrayList<Integer>();
                //Access every index where the key string is found on the line
                //If none is found, stop the loop.
                for (int i = 0; (i = readingLine.indexOf(keyString, i)) != -1; i++) {
                    indexList.add(i);
                }

                //Check if the list is empty and no result has been found before
                if (indexList.isEmpty() == false && hasResult == false) {
                    hasResult = true;
                } //Else the key string must be found on the line.
                    //Loop each time the key str is found
                    for (int beginPos : indexList) {
                        int endPos = beginPos + keyString.length();
                        String outputString = "";

                        //Add characters from the start of the word to the index where the keyString is found to the output.
                        int x = beginPos;
                        //Access every char from the char previous to the index where the keyString is found
                        //to the first char of the word
                        while (true) {
                            //If the current index is lesser than 0, it means that the index has already reached the start of the line in the previous loop
                            if (x - 1 < 0) {
                                break;
                            }
                            //If the current index reached a whitespace, break.
                            else if (Character.isWhitespace(readingLine.charAt(x - 1))) {
                                break;
                            } 
                            //Else add the char to the output string
                            else {
                                outputString = readingLine.charAt(x - 1) + outputString;
                                x--;
                            }
                        }
                        //Add characters from the key string to the output
                        outputString = outputString + readingLine.substring(beginPos, endPos);

                        //Add characters from the char after the final char of the key string until the end of the word.
                        int y = endPos;
                        //Access every char from the char next to the index where the keyString is found
                        //to the final char of the word
                        while (true) {
                            //If the current index reached the end of the line, break
                            if (y == readingLine.length()) {
                                break;
                            } 
                            //If the current index reached a whitespace, break
                            else if (Character.isWhitespace(readingLine.charAt(y)) == true) {
                                break;
                            } 
                            //Else add the char to output string
                            else {
                                outputString = outputString + readingLine.charAt(y);
                                y++;
                            }
                        }
                        System.out.println("     " + outputString);
                    }
            }
            
            //If there is no result, announce
            if(hasResult == false) System.out.println("      Not found!");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }
/*
    private static File enterAndLoad_File() {
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

    private static String inputString() {
        Scanner keyboard = new Scanner(System.in);
        String keyString = "";
        //This loop only breaks if the string is not empty
        while (true) {
            System.out.print("Please enter string to search: ");
            keyString = keyboard.nextLine();
            //Check if the keyString is empty.
            if (keyString.isEmpty()) {
                System.out.println("The string must not be empty. Try again.");
            } //If the above conditions aren't met, the string must be correct.
            else {
                break;
            }

        }
        return keyString;
    }

    private static void findString(File fileName, String findString) throws FileNotFoundException {
        try {
            Scanner myReader = new Scanner(fileName);
            System.out.println("\nSearch results:");

            //Access each line of the text file
            while (myReader.hasNextLine()) {
                String w = myReader.nextLine();
                String[] a = w.split(" ");
                //loop run from first to last element of String a
                for (String string : a) {
                    if (string.contains(findString)) {
                        System.out.println(string);
                    }
                }

            }

            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("Can not find this word in file");
        }
        System.out.println("...");
    }
    */
}
