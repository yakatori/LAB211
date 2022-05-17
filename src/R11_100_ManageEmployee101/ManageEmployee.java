/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package R11_100_ManageEmployee101;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author admin
 */
public class ManageEmployee {

    List<Employee> listEmployees = new ArrayList<>();

    public Employee getEmployeeByID(int id) {
        //loop run from first to last element of listEmployees
        for (Employee employee : listEmployees) {
            //if duplicate id => return Employee has existed
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    public List<Employee> getListEmployees() {
        return listEmployees;
    }

    public boolean checkDuplicate(String phone, String email) {
        //loop run from first to last element of listEmployees
        for (Employee e : listEmployees) {
            //check duplicate
            if (e.getPhone().equalsIgnoreCase(phone)
                    || e.getEmail().equalsIgnoreCase(email)) {
                return true;
            }

        }
        return false;
    }

    public boolean checkNotUpdate(int id, String firstName, String lastName,
            String phone, String email, String address, String dob, int sex,
            double salary, String agency) {
        //loop run from first to last element of listEmployees
        for (Employee e : listEmployees) {
            //check duplicate
            if (e.getPhone().equalsIgnoreCase(phone)
                    && e.getEmail().equalsIgnoreCase(email)
                    && e.getId()== id
                    && e.getFirstName().equalsIgnoreCase(firstName)
                    && e.getLastName().equalsIgnoreCase(lastName)
                    && e.getDob().equalsIgnoreCase(dob)
                    && e.getSalary()== salary
                    && e.getAddress().equalsIgnoreCase(address)
                    && e.getSexInt()== sex
                    && e.getAgency().equalsIgnoreCase(agency)
                    ) {
                return true;
            }

        }
        return false;

    }

    public Employee getEmployeeByName(String name) {
        //loop run from first to last element in listEmployees
        for (Employee employee : listEmployees) {
            if (employee.getFirstName().toUpperCase().contains(name.toUpperCase())
                    || employee.getLastName().toUpperCase().contains(name.toUpperCase())) {
                return employee;
            }
        }
        return null;
    }

    public void addEmployee(Employee employee) {

        listEmployees.add(employee);
    }

    public void updateEmployee(int idUpdate, String firstName, String lastName,
            String phone, String email, String address, String dob, int sex,
            double salary, String agency, Employee employee) {
        employee.setId(idUpdate);
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setPhone(phone);
        employee.setEmail(email);
        employee.setAddress(address);
        employee.setDob(dob);
        employee.setSex(sex);
        employee.setSalary(salary);
        employee.setAgency(agency);

    }

    public void removeEmployee(Employee employee) {
        listEmployees.remove(employee);
    }

    public List<Employee> findEmployeeByName(String name) {
        List<Employee> listSearch = new ArrayList<>();
        //loop run from first to last element in listEmployees
        for (Employee employee : listEmployees) {
            //compare name to find Employee by name then add to listSearch
            if (employee.getFirstName().toUpperCase().contains(name.toUpperCase())
                    || employee.getLastName().toUpperCase().contains(name.toUpperCase())) {
                listSearch.add(employee);
            }
        }
        return listSearch.isEmpty() ? null : listSearch;

    }

    public List<Employee> sortBySalary() {
        List<Employee> listSort = new ArrayList<>();
        listSort.addAll(listEmployees);

        if (listSort.isEmpty()) {
            return null;
        }

        //Loop run from the first to last element of listSort 
        for (int i = 0; i < listSort.size(); i++) {
            /*Loop run from first element to the 
           element stand before the last unsorted element */
            for (int j = 0; j < listSort.size() - i - 1; j++) {
                //Compare each pair adjacent elements
                if (listSort.get(j).getSalary() > listSort.get(j + 1).getSalary()) {
                    Employee temp = listSort.get(j);
                    listSort.set(j, listSort.get(j + 1));
                    listSort.set(j + 1, temp);
                }

            }
        }
        return listSort;
    }

}
