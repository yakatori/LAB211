/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package M21_25loc_PersonInfo63;

import java.util.ArrayList;
import java.util.List;

/*
 *
 * @author admin
 */
public class Main {

    public static void main(String[] args) {
        List<Person> listPersons = new ArrayList<Person>();
        //Step1: input person information
         ManagePerson.inputPersonInfo(listPersons);
        //Step2: sort person list by salary and display
        ManagePerson.sortBySalary(listPersons);
    }

}
