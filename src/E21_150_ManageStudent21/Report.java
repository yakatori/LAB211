/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package E21_150_ManageStudent21;

/**
 *
 * @author admin
 */
public class Report {

    private String name;
    private int course;
    private int totalCourse;

    public Report(String name, int course, int totalCourse) {
        this.name = name;
        this.course = course;
        this.totalCourse = totalCourse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public int getTotalCourse() {
        return totalCourse;
    }

    public void setTotalCourse(int totalCourse) {
        this.totalCourse = totalCourse;
    }

    public String getCourse(int course) {
        String courseTemp = null;
        switch (course) {
            case 1:
                courseTemp = "Java";
                break;
            case 2:
                courseTemp = ".Net";
                break;
            case 3:
                courseTemp = "C/C++";

        }

        return courseTemp;
    }

    @Override
    public String toString() {
        return String.format("%-20s | %-10s | %-10s", name, getCourse(course), totalCourse);
    }
}
