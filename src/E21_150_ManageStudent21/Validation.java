/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package E21_150_ManageStudent21;

import java.util.List;

/**
 *
 * @author admin
 */
public class Validation {
public static boolean checkWrongName(String id, String name, List<Student> listStudents) {
        //loop from first to last element in list 
        for (Student student : listStudents) {
            //if studentID = id and studentName != name => wrong name, return true
            if (student.getId().equalsIgnoreCase(id) && student.getName().equalsIgnoreCase(name)
                    == false) {
                System.out.println("ID must has name " + student.getName());
                return true;
            }
        }
        return false;
    }

    static boolean checkDuplicate(String id, int semester, int course,String name, List<Student> listStudents) {
        //loop from first to last element to check duplicate
        for (Student student : listStudents) {
            //if id,semester and course is duplicate then return true
            if (student.getId().equalsIgnoreCase(id)
                    && student.getSemester() == semester
                    && student.getCourse()== course
                    && student.getName().equalsIgnoreCase(name)) {
                System.out.println(student.getName() + " was enrolled " + student.getCourse()
                        + " in semester " + student.getSemester());
                return true;
            }
        }
        return false;
    }

    static boolean checkYesNo() {

        String result = GetInput.getString("Do you want to continue Y/N. Choose Y "
                + "to continue, N to return "
                + "main screeen: ", "It must be Y or N", GetInput.REGEX_YES_NO);
        if (result.equalsIgnoreCase("y")) {
            return true;
        } else {
            return false;
        }
    }

    static boolean checkStudentExist(String id, List<Student> listStudents) {
        for (Student student : listStudents) {
            //if student co id trung voi id nhap vao => return true
            if (student.getId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        
        
        return false;
    }

    static boolean checkUpdateOrDelete() {
        String result = GetInput.getString("Do you want to update (U) or delete (D)"
                + " student. Choose U to update, D to delete", "It must be U or D", GetInput.REGEX_UPDATE_DELETE);
        //if result == u => true <=> update
        if (result.equalsIgnoreCase("u")) {
            return true;
        }
        return false;
    }

    static boolean checkNotUpdate(String id, String name, int semester, int course, Student studentChoice) {
        //if all attribute equal to input attribute => not update => true
        //else update => false
        if (studentChoice.getId().equalsIgnoreCase(id) && 
                studentChoice.getName().equalsIgnoreCase(name) && 
                studentChoice.getSemester() == (semester) && 
                studentChoice.getCourse()== course ) {
            return true;
        }
        return false;

    }

    static boolean checkExistReport(Student firstStudent, List<Report> listReport) {
        for (Report report : listReport) {
            if (report.getName().equalsIgnoreCase(firstStudent.getName()) && 
                    report.getCourse()== firstStudent.getCourse()) {
                return true;
            }
        }
        return false;

    }   
}
