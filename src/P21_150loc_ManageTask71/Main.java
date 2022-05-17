/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P21_150loc_ManageTask71;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class Main {

    public static void main(String[] args) throws ParseException {
        List<Task> listTask = new ArrayList<>();
        ViewTask viewTask = new ViewTask();
        while (true) {
            displayMenu();
            int option = GetInput.getInt("Option: ", "It must be digit", 1, 4);
            switch (option) {
                case 1:
                    //input task information
                    viewTask.inputTask(listTask);
                    break;
                case 2:
                    //delete a task
                    viewTask.deleteTask(listTask);
                    break;
                case 3:
                    //display task
                    viewTask.displayTask(listTask);
                    break;
                case 4:
                    System.exit(0);
                    break;
            }
        }
    }

    private static void displayMenu() {
        System.out.println("========= Task program =========\n"
                + "1.	Add Task\n"
                + "2.	Delete task\n"
                + "3.	Display Task\n"
                + "4.	exit");
    }
}
