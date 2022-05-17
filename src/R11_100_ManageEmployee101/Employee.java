/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package R11_100_ManageEmployee101;

import java.util.Date;

/**
 *
 * @author admin
 */
public class Employee {

    public static int auto_Increment = 1;
    int id;
    String firstName;
    String lastName;
    String phone;
    String email;
    String address;
    String dob;
    int sex;
    double salary;
    String agency;

    public Employee() {
    }

    public Employee(int id, String firstName, String lastName, String phone,
            String email, String address, String dob, int sex, double salary, String agency) {
        this.id = auto_Increment++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.dob = dob;
        this.sex = sex;
        this.salary = salary;
        this.agency = agency;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getSex() {
        String sextemp = null;
        switch (sex) {
            case 1:
                sextemp = "Male";
                break;
            case 0:
                sextemp = "Female";
                break;

        }
        return sextemp;
    }

    public int getSexInt() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    @Override
    public String toString() {
        return String.format("%-5s %-20s %-20s %-20s %-20s %-20s %-20s %.2f %-20s", id, firstName + " " + lastName,
                phone, email,address, dob, getSex(), salary, agency);
    }

}
