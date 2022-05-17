/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package M21_25loc_PersonInfo63;

import java.util.List;

/**
 *
 * @author admin
 */
public class ManagePerson {

    public static void inputPersonInfo(List<Person> listPerson) {
        System.out.print("=====Management Person programer=====\n");
        //if size of listPerson <3, user can add new Person information to listPerson

        while (listPerson.size() < 3) {
            System.out.println("Input Information of Person");
            /*regex:
                    [a-zA-Z ]+ : matches characters a to z, A to Z and space

             */
            String regexString = "[a-zA-Z ]+";
            String name = GetInput.getString("Please input name:",
                    "Invailed name! Re-enter!!", regexString);
            String address = GetInput.getString("Please input adress:",
                    "Invailed address! Re-enter!!", regexString);
            double salary = GetInput.getDouble("Please input salary:",
                    "You must input digidt.", 0, Double.MAX_VALUE);
            listPerson.add(new Person(name, address, salary));
        }

    }

    //Sort an array by using bubble sort algorithm
    public static void sortBySalary(List<Person> listPerson) {

        //Loop run from the first to last Person of array 
        for (int i = 0; i < listPerson.size(); i++) {

            /*Loop run from first element to the 
            element stand before the last unsorted element */
            for (int j = 0; j < listPerson.size() - i - 1; j++) {

                //Compare each pair adjacent elements
                if (listPerson.get(j).getSalary() > listPerson.get(j + 1).getSalary()) {
                    Person temp = listPerson.get(j);
                    listPerson.set(j, listPerson.get(j + 1));
                    listPerson.set(j + 1, temp);

                }
            }
        }
        //loop to display information
        for (Person person : listPerson) {
            System.out.println("Information of Person you have entered:");
            System.out.println(person);
        }
    }

}
