/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package R11_100_ManageEmployee101;

import java.util.Date;
import java.util.List;

/**
 *
 * @author admin
 */
public class ViewEmployee {

    ManageEmployee manage = new ManageEmployee();

    void addEmp(Employee employee) {
        manage.addEmployee(employee);
    }

    void inputEmployee() {

        String firstName = GetInput.getFirstName();
        String lastName = GetInput.getLastName();
        String phone = GetInput.getPhone();
        String email = GetInput.getEmail();
        String address = GetInput.getAddress();
        String dob = GetInput.getDOB();
        int sex = GetInput.getSex();
        double salary = GetInput.getSalary();
        String agency = GetInput.getAgency();

        Employee employee = new Employee(sex, firstName, lastName, phone, email,
                address, dob, sex, salary, agency);
        if (manage.checkDuplicate(phone, email) == true) {
            System.out.println("CAN NOT ADD- DUPLICATE PHONE/EMAIL\nPhone Number and Email must unique");
        } else {
            manage.addEmployee(employee);
            System.out.println(employee);

        }
    }

    void updateEmployee() {
        String firstName;
        String lastName;
        String phone;
        String email;
        String address;
        String dob;
        int sex;
        double salary;
        String agency;

        int id = GetInput.getID();
        Employee employee = manage.getEmployeeByID(id);
        if (employee == null) {
            System.out.println("NOT FOUND ID");
            return;
        }

        int idUpdate;
        //check update ID, true => update
        while (true) {
            
            if (GetInput.checkWantToUpdate("id") == true) {
                idUpdate = GetInput.getID();
                //check employee has ID, !null => duplicate
                if (manage.getEmployeeByID(idUpdate) != null) {
                    System.out.println("DUPLICATE ID");
                } else {
                    employee.setId(idUpdate);
                    break;
                }
            } else {
                idUpdate = employee.getId();
                break;
            }
        }

        //check update first name, true => update
        if (GetInput.checkWantToUpdate("first name") == true) {
            firstName = GetInput.getFirstName();
        } else {
            firstName = employee.getFirstName();
        }

        //check update last name, true => update
        if (GetInput.checkWantToUpdate("lastName") == true) {
            lastName = GetInput.getLastName();
        } else {
            lastName = employee.getLastName();
        }

        //check update phone, true => update
        if (GetInput.checkWantToUpdate("phone") == true) {
            phone = GetInput.getPhone();
        } else {
            phone = employee.getPhone();
        }

        //check update email, true => update
        if (GetInput.checkWantToUpdate("email") == true) {
            email = GetInput.getEmail();
        } else {
            email = employee.getEmail();
        }

        //check update address, true => update
        if (GetInput.checkWantToUpdate("address") == true) {
            address = GetInput.getAddress();
        } else {
            address = employee.getAddress();
        }
        //check update DOB, true => update
        if (GetInput.checkWantToUpdate("dob") == true) {
            dob = GetInput.getDOB();
        } else {
            dob = employee.getDob();
        }
        //check update sex, true => update
        if (GetInput.checkWantToUpdate("sex") == true) {
            sex = GetInput.getSex();
        } else {
            sex = employee.getSexInt();
        }
        //check update salary, true => update
        if (GetInput.checkWantToUpdate("salary") == true) {
            salary = GetInput.getSalary();
        } else {
            salary = employee.getSalary();
        }
        //check update agency, true => update
        if (GetInput.checkWantToUpdate("agency") == true) {
            agency = GetInput.getAgency();
        } else {
            agency = employee.getAgency();
        }
        if (manage.checkNotUpdate(idUpdate, firstName, lastName, phone, email, address, dob, sex, salary, agency) == true) {
            System.out.println("YOU NOT UPDATE !!!");
        } else if (manage.checkDuplicate(phone, email) == true) {
            System.out.println("UPDATE FAIL- DUPLICATE PHONE/EMAIL\nPhone Number and Email must unique");
        } else {
            manage.updateEmployee(idUpdate, firstName, lastName, phone, email, address,
                    dob, sex, salary, agency, employee);
            System.out.println("UPDATE SUCCESSFULL");
        }
    }

    void removeEmployee() {
        int id = GetInput.getID();
        Employee employee = manage.getEmployeeByID(id);

        if (employee == null) {
            System.out.println("NOT FOUND");
            return;
        }

        manage.removeEmployee(employee);
        System.out.println("REMOVE SUCCESSFULL");

    }

    void search() {
        String name = GetInput.getString("Enter name: ", "It must be string!!", GetInput.REGEX_NAME);

        List<Employee> listEmployees = manage.findEmployeeByName(name);
        if (listEmployees == null) {
            System.out.println("NOT FOUND !!");
        } else {
            for (Employee employee : listEmployees) {
                System.out.println(employee);
            }
        }

    }

    void sort() {
        List<Employee> listSort = manage.sortBySalary();
        if (listSort == null) {
            System.out.println("NO EMPLOYEE IN LIST");
        } else {
            for (Employee employee : listSort) {
                System.out.println(employee);
            }
        }

    }

}
