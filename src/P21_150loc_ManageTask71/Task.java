/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P21_150loc_ManageTask71;

import java.util.Date;

/**
 *
 * @author admin
 */
public class Task {

    private static int autoIncrement = 1;
    private int id;
    private int taskTypeID;
    private String requirementName;
    private String date;
    private double planFrom;
    private double planTo;
    private String assignee;
    private String reviewer;

    public Task(int taskTypeID, String requirementName, String date, double planFrom, double planTo, String assignee, String reviewer) {
        this.id = autoIncrement++;
        this.taskTypeID = taskTypeID;
        this.requirementName = requirementName;
        this.date = date;
        this.planFrom = planFrom;
        this.planTo = planTo;
        this.assignee = assignee;
        this.reviewer = reviewer;
    }

    public Task() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaskTypeID() {
        String taskName = null;
        switch (taskTypeID) {
            case 1:
                taskName = "Code";
                break;
            case 2:
                taskName = "Test";
                break;
            case 3:
                taskName = "Design";
                break;
            case 4:
                taskName = "Review ";
                break;
        }
        return taskName;
    }

    public void setTaskTypeID(int taskTypeID) {
        this.taskTypeID = taskTypeID;
    }

    public String getRequirementName() {
        return requirementName;
    }

    public void setRequirementName(String requirementName) {
        this.requirementName = requirementName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getPlanFrom() {
        return planFrom;
    }

    public void setPlanFrom(double planFrom) {
        this.planFrom = planFrom;
    }

    public double getPlanTo() {
        return planTo;
    }

    public void setPlanTo(double planTo) {
        this.planTo = planTo;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public double getTime() {
        return planTo - planFrom;
    }

    @Override
    public String toString() {
        return String.format("%-5s %-15s %-15s %-15s %-10s %-15s %-15s", getId(),
                getRequirementName(), getTaskTypeID(), getDate(), getTime(), getAssignee(),
                getReviewer());
    }
}
