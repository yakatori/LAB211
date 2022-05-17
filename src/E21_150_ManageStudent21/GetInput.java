/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package E21_150_ManageStudent21;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class GetInput {

    public static Scanner scanner = new Scanner(System.in);
    /*
         regex:
                a-z: matches character from a-z
                A-Z: matches character from A-Z
                   : matches with SPACE
                +  : matches the previous token between one and unlimited times
                0-9: matches with digit from 0-9
                .  : matches with character .
                /  : matches with character /
     */

    public static final String REGEX_ID = "[a-zA-Z0-9 ]+";
    public static final String REGEX_NAME = "[a-zA-Z ]+";
    public static final String REGEX_SEMESTER = "[0-9]";
    public static final String REGEX_COURSE_NAME = "[a-zA-Z.+/ ]+";
    public static String REGEX_YES_NO = "[yYnN]";
    public static final String REGEX_UPDATE_DELETE = "[uUdD]";

    public static int getInt(String message, String error, int min, int max) {
        while (true) {
            try {
                System.out.print(message);
                String input = scanner.nextLine();
                //if input is empty then tell user
                if (input.isEmpty()) {
                    System.out.println("Input cannot be empty !!!");
                } //kiem tra dau vao co dung dinh dang khong
                else {
                    int number = Integer.parseInt(input);
                    //if number in range then return number
                    //else tell user number must in range
                    if (min <= number && number <= max) {
                        return number;
                    } else {
                        System.out.println("Input must in range from "
                                + min + " to " + max);
                    }

                }
            } catch (NumberFormatException e) {
                System.out.println(error);
            }
        }

    }

    public static double getDouble(String message, String error, double min, double max) {
        while (true) {
            try {
                System.out.print(message);
                String input = scanner.nextLine().trim();
                //if input is empty then tell user
                if (input.isEmpty()) {
                    System.out.println("Input cannot be empty !!!");
                } //kiem tra dau vao co dung dinh dang khong
                else {
                    double number = Double.parseDouble(input);
                    //if number in range then return number
                    //else tell user number must in range
                    if (min <= number && number <= max) {
                        return number;
                    } else {
                        System.out.println("Input must in range from "
                                + min + " to " + max);
                    }

                }
            } catch (NumberFormatException e) {
                System.out.println(error);
            }
        }

    }

    public static String getString(String message, String error, String regex) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();
            //if input empty then tell user 
            //else is input matches with regex ?
            if (input.isEmpty()) {
                System.out.println("Input cannot be empty !!!");
            } else {
                //if input matches with regex then return input
                //else announce error
                if (input.matches(regex)) {
                    return input;
                } else {
                    System.out.println(error);
                }
            }
        }
    }

    public static String getName(String id, List<Student> listStudents) {
        while (true) {
            String name = getString("Enter name: ", "Name must be letters", REGEX_NAME);
            //if name matches with id => return name
            if (!Validation.checkWrongName(id, name, listStudents)) {
                return name;
            }
        }

    }

    public static int getSemester() {
        int semester = getInt("Enter semester: ", "semester must be digit", 0, Integer.MAX_VALUE);
        return semester;
    }


    public static int getCourse() {
        int course = getInt("Course: 1/ Java  2/ .Net    3/ C/C++\nEnter course: ", "It must be digit", 1, 3);
        return course;
    }

    public static String getID() {
        String id = getString("Enter id: ", "ID must be letter and digit", GetInput.REGEX_ID);
        return id;
    }

    private static String findNameByID(String id, List<Student> listStudents) {
        //loop from first to last element to get name match with id
        for (Student student : listStudents) {
            //if student has id equal to id input then return student name
            if (student.getId().equalsIgnoreCase(id)) {
                return student.getName();
            }
        }
        return null;
    }

}
