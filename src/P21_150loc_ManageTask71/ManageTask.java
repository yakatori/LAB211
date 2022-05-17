/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P21_150loc_ManageTask71;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 *
 * @author admin
 */
public class ManageTask {



    private static boolean checkDuplicateTask(String date, String assignee, double planFrom, double planTo, List<Task> listTask) {
        //loop run from first to last task of listTask
        for (Task task : listTask) {
            //if task has assgigned or duplicate plant time
            if (task.getDate().equals(date) && task.getAssignee().equalsIgnoreCase(assignee)) {

                if (task.getPlanFrom() > planFrom && planTo > task.getPlanFrom()) {
                    return true;
                }
                if (task.getPlanFrom() < planFrom && task.getPlanTo() <= planTo
                        && planFrom < task.getPlanTo()) {
                    return true;
                }
                if (task.getPlanFrom() == planFrom && planTo == task.getPlanFrom()) {
                    return true;
                }
            }
        }
        return false;

    }
    public static int addTask(int taskTypeID, String requirementName, String date,
            double planFrom, double planTo, String assignee, String reviewer, List<Task> listTask) {

        //check duplicate task 
        if (checkDuplicateTask(date, assignee, planFrom, planTo, listTask) == true) {
            return 0;
        }
        Task task = new Task(taskTypeID, requirementName, date, planFrom, planTo, assignee, reviewer);
        listTask.add(task);
        return task.getId();

    }
    public static int delete(int id, List<Task> listTask) {

        //loop run from first to last element of listTask
        for (Task task : listTask) {
            //if find id needed to deleted
            if (task.getId() == id) {
                listTask.remove(task);
                return id;
            }
        }
        return 0;

    }

    public static List<Task> sortList(List<Task> listTask) {
        List<Task> listSort = new ArrayList<>();
        listSort.addAll(listTask);

        /*Loop from the first to last person , 
        after each loop, one task is sorted*/
        for (int i = 0; i < listSort.size(); i++) {
            //Loop from first to last task through unsorted task
            for (int j = 0; j < listSort.size() - 1 - i; j++) {
                //swap two person if not in ascending order
                if (listSort.get(j).getId() > listSort.get(j + 1).getId()) {
                    Task temp = listSort.get(j);
                    listSort.set(j, listSort.get(j + 1));
                    listSort.set(j + 1, temp);
                }
            }
        }

        return listSort;
    }

    

}
