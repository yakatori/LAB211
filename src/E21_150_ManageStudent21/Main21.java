/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package E21_150_ManageStudent21;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class Main21 {

    public static void main(String[] args) {
        List<Student> listStudents = new ArrayList<Student>();
        listStudents.add(new Student("HE161", "Vu Ha", 2, 1));
        listStudents.add(new Student("HE162", "Mai Anh", 1, 2));
        listStudents.add(new Student("HE163", "Hong Huy", 3, 2));
        listStudents.add(new Student("HE164", "Tran Minh", 3, 2));
        listStudents.add(new Student("HE161", "Vu Ha", 3, 1));
        listStudents.add(new Student("HE163", "Hong Huy", 1, 3));
        listStudents.add(new Student("HE163", "Hong Huy", 2, 3));
        listStudents.add(new Student("HE166", "Ha Anh", 1, 3));
        listStudents.add(new Student("HE164", "Tran Minh", 1, 3));

        while (true) {
            displayMenu();
            int option = GetInput.getInt("Option: ", "Option must be digit", 1, 6);
            switch (option) {
                case 1:
                    ManageStudent.create(listStudents);
                    break;
                case 2:
                    ManageStudent.findAndSort(listStudents);
                    break;
                case 3:
                    ManageStudent.updateOrDelete(listStudents);
                    break;
                case 4:
                    ManageStudent.report(listStudents);
                    break;
                case 5:
                    System.exit(0);
                    break;
                case 6:
                    ManageStudent.displayData(listStudents);
            }
        }
    }

    public static void displayMenu() {
        System.out.println("WELCOME TO STUDENT MANAGEMENT\n"
                + "1.	Create\n"
                + "2.	Find and Sort\n"
                + "3.	Update/Delete\n"
                + "4.	Report\n"
                + "5.	Exit");
    }
}
