/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package E21_150_ManageStudent21;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author admin
 */
public class ManageStudent {

    public static void create(List<Student> listStudents) {
        //if list student > 10 => ask user 
        if (listStudents.size() >= 10) {
            if (!Validation.checkYesNo()) {
                return;
            }
        }

        String id = GetInput.getID();
        String name = GetInput.getName(id, listStudents);
        int semester = GetInput.getSemester();
        int course = GetInput.getCourse();
        
        //if id, semester, course not duplicate => add into list
        if (!Validation.checkDuplicate(id, semester, course, name, listStudents)) {
            listStudents.add(new Student(id, name, semester, course));
            return;
        }

    }

    public static void displayData(List<Student> listStudents) {
        for (Student student : listStudents) {
            System.out.println(student);
        }
    }

    public static void findAndSort(List<Student> listStudents) {
        String name = GetInput.getString("Enter name: ", "Name must be letter",
                GetInput.REGEX_NAME);
        List<Student> listFound = new ArrayList<>();
        for (Student student : listStudents) {
            //if student has name contain name input => add to listFound
            if (student.getName().toUpperCase().contains(name.toUpperCase())) {
                listFound.add(student);
            }
        }

        //if listFound empty => not found name
        if (listFound.size() == 0) {
            System.out.println("NOT FOUND");
            return;
        }

         //Loop run from the first to last Person of array 
        for (int i = 0; i < listStudents.size(); i++) {

            /*Loop run from first element to the 
            element stand before the last unsorted element */
            for (int j = 0; j < listStudents.size() - i - 1; j++) {

                //Compare each pair adjacent elements
                if (listStudents.get(j).getName().compareToIgnoreCase(listStudents.get(j + 1).getName())>0)  {
                    Student temp = listStudents.get(j);
                    listStudents.set(j, listStudents.get(j + 1));
                    listStudents.set(j + 1, temp);

                }
            }
        }
        displayData(listFound);
        System.out.println("After sort by Student name: ");
        displayData(listStudents);

    }

    public static void updateOrDelete(List<Student> listStudents) {
        String id = GetInput.getID();
        //checkStudentExist == false => student not exist => return
        if (Validation.checkStudentExist(id, listStudents) == false) {
            System.out.println("STUDENT NOT FOUND");
            return;
        }
        List<Student> listFoundByID = findStudentByID(id, listStudents);

        //if user choose u/U => true
        //else choose d/D => false
        if (Validation.checkUpdateOrDelete() == true) {
            updateStudent(listFoundByID, listStudents);
        } else {
            deleteStudent(listFoundByID, listStudents);
        }

    }

    private static void updateStudent(List<Student> listFoundByID, List<Student> listStudents) {

        displayStudentByID(listFoundByID);
        int choice = GetInput.getInt("Choice: ", "Choice must be digit", 0, listFoundByID.size() - 1);
        Student studentChoice = listFoundByID.get(choice);

        String id = GetInput.getID();
        String name = GetInput.getString("Enter name: ", "Name must be letter and digit", GetInput.REGEX_NAME);
        int semester = GetInput.getSemester();
        int course = GetInput.getCourse();

        //if id, name, semester, course not update => tell error
        if (Validation.checkNotUpdate(id, name, semester, course, studentChoice) == true) {
            System.out.println("YOU NOT UPDATE !!!");
            return;
        }

        //if id, semester, course is equal to student in list => tell user
        if (!Validation.checkDuplicate(id, semester, course, name, listStudents)) {
            listStudents.get(listStudents.indexOf(studentChoice)).setId(id);
            updateNameOfStudent(id, name, listStudents);
            listStudents.get(listStudents.indexOf(studentChoice)).setSemester(semester);
            listStudents.get(listStudents.indexOf(studentChoice)).setCourse(course);
        }

    }

    private static void deleteStudent(List<Student> listFoundByID, List<Student> listStudents) {
        displayStudentByID(listFoundByID);
        int choice = GetInput.getInt("Choice: ", "Choice must be digit", 0, listFoundByID.size() - 1);
        Student studentChoice = listFoundByID.get(choice);

        listStudents.remove(studentChoice);

    }

    private static List<Student> findStudentByID(String id, List<Student> listStudents) {
        List<Student> listFoundByID = new ArrayList<>();
        //loop from first to last element of listStudents
        for (Student student : listStudents) {
            //if student has ID equal to id input => add that student into listFoundByID
            if (student.getId().equalsIgnoreCase(id)) {
                listFoundByID.add(student);
            }
        }
        return listFoundByID;
    }

    private static void displayStudentByID(List<Student> listFoundByID) {
        int count = 0;
        System.out.printf("%-10s %-15s%-20s%-10s%-10s\n", "Choice", "ID", "Name", "Semester", "Course");
        for (Student student : listFoundByID) {

            System.out.printf("%-10s %-10s\n", count, student);
            count++;
        }

    }

    private static void updateNameOfStudent(String id, String name, List<Student> listStudents) {
        //loop from first to last element to update all name of student have id input
        for (Student student : listStudents) {
            if (student.getId().equalsIgnoreCase(id)) {
                student.setName(name);
            }
        }
    }

    public static void report(List<Student> listStudents) {
        List<Report> listReport = new ArrayList<>();
        //loop run to first Student to last Student in listStudents
        for (Student firstStudent : listStudents) {
            int total = 0;
            //loop run to first Student to last Student in listStudents
            for (Student secondStudent : listStudents) {
                //Compare name, id, course to get total of course of one Student
                if (firstStudent.getId().equalsIgnoreCase(secondStudent.getId())
                        &&firstStudent.getName().equalsIgnoreCase(secondStudent.getName())
                        && firstStudent.getCourse() == secondStudent.getCourse()) {
                    total++;
                }

            }
            //check duplicate student in report
            if (Validation.checkExistReport(firstStudent, listReport) == false) {
                listReport.add(new Report(firstStudent.getName(), firstStudent.getCourse(), total));
            }
        }
        //loop run from first student to last student in listReport and display
        for (Report report : listReport) {
            System.out.println(report);
        }

    }
}
