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
public class Student {

    private String id;
    private String name;
    private int semester;
    private int course;

    public Student(String id, String name, int semester, int course) {
        this.id = id;
        this.name = name;
        this.semester = semester;
        this.course = course;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
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
        return String.format("%-15s%-20s%-10s%-10s", id, name, semester,
                getCourse(course));
    }
}
