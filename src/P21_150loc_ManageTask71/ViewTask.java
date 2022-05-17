/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P21_150loc_ManageTask71;

import java.text.ParseException;
import java.util.List;

/**
 *
 * @author admin
 */
public class ViewTask {
    ManageTask manageTask = new ManageTask();
    static void inputTask(List<Task> listTask) throws ParseException {
        String requirementName = GetInput.getString("Requirement Name: ",
                "It must be letter or digit", GetInput.REGEX_NAME);
        int taskTypeID = GetInput.getInt("Task Type: ", "It must be digit", 1, 4);
        String date = GetInput.getDate("Date: ", "Invalid date or date must have format dd-MM-yyyy");
        double planFrom = GetInput.getDouble("From: ", "It must be from 8h - 17h", 8, 17);
        double planTo = GetInput.getDouble("To: ", "It must be from 8h - 17h30", 8, 17.5);
        String assignee = GetInput.getString("Assignee: ",
                "It must be letter or digit", GetInput.REGEX_NAME);
        String reviewer = GetInput.getString("Reviewer: ",
                "It must be letter or digit", GetInput.REGEX_NAME);

        int temp = ManageTask.addTask(taskTypeID, requirementName, date, planFrom,
                planTo, assignee, reviewer, listTask);

        //if temp == 0 => OVERLAPS TASK 
        if (temp == 0) {
            System.out.println("OVERLAPS TASK");
        } else {
            System.out.println("ADD SUCCESSFULLY!!!");
        }
    }

    static void deleteTask(List<Task> listTask) {
        int id = GetInput.getInt("Enter ID: ", "It must be digit", 1, Integer.MAX_VALUE);

        int IDremove = ManageTask.delete(id, listTask);
        //if IDremove = 0 => NOT FOUND ID
        if (IDremove == 0) {
            System.out.println("NOT FOUND TASK");
        } else {
            System.out.println("DELETE SUCCESSFULL");
        }

    }

    static void displayTask(List<Task> listTask) {
        List<Task> listSort = ManageTask.sortList(listTask);
        if (listSort.isEmpty()) {
            System.out.println("NOT FOUND TASK");
            return;
        }

        System.out.println("----------------------------------------- Task ---------------------------------------");
        System.out.printf("%-5s %-15s %-15s %-15s %-10s %-15s %-15s\n", "ID",
                "Name", "Task Type", "Date", "Time", "Assignee", "Reviewer");
        for (Task task : listSort) {
            System.out.println(task);
        }

    }
}
