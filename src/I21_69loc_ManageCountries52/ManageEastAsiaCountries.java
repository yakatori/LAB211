/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package I21_69loc_ManageCountries52;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author admin
 */
public class ManageEastAsiaCountries {

    private static boolean checkDuplicate(String code, String name, List<EastAsiaCountries> listCountries) {
        //loop from first to last element of listCountries
        for (EastAsiaCountries country : listCountries) {
            //if country has code and name equal to code and name input => Duplicated
            if (country.getCountryCode().equalsIgnoreCase(code)
                    && country.getCountryName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public static void inputCountries(List<EastAsiaCountries> listCountries) {
        // if list full then tell user and return
        if (listCountries.size() == 11) {
            System.out.println("\nCAN NOT ADD! LIST IS FULLED!!!");
            return;
        }
        // Loop until listcountries's size is 11
        while (true) {
            String code = GetInput.getString("Enter code of country: ",
                    "It must digit or letters", GetInput.REGEX_NAME);
            String name = GetInput.getString("Enter name of country: ",
                    "It must digit or letters", GetInput.REGEX_NAME);

            //check duplicate country has just added then tell user
            if (checkDuplicate(code, name, listCountries)) {
                System.out.println("COUNTRY HAD BEEN ADDED BEFORE");
            } else {
                float area = GetInput.getFloat("Enter total Area: ",
                        "It must digit", 0, Float.MAX_VALUE);
                String terrarin = GetInput.getString("Enter terrain of country: ",
                        "It must digit or letters", GetInput.REGEX_NAME);
                EastAsiaCountries country = new EastAsiaCountries();
                listCountries.add(new EastAsiaCountries(code, name, area, terrarin));
                break;
            }
        }

    }

    public static void searchCountryByName(List<EastAsiaCountries> listCountries) {
        String name = GetInput.getString("Enter name of country: ",
                "It must digit or letters", GetInput.REGEX_NAME);
        List<EastAsiaCountries> listSearch = new ArrayList<>();
        //loop from first to last element of listCountries
        for (EastAsiaCountries country : listCountries) {
            //if country contain name then add to listSearch
            if (country.getCountryName().toUpperCase().contains(name.toUpperCase())) {
                listSearch.add(country);
            }
        }

        //if listsearch is empty => not found country
        if (listSearch.isEmpty()) {
            System.out.println("NOT FOUND COUNTRY");
            return;
        }

        System.out.format("%-10s %-25s %-20s %-25s\n", "ID", "Name",
                "Total Area", "Terrarin");
        //loop run to display searched country
        for (EastAsiaCountries eastAsiaCountries : listSearch) {
            eastAsiaCountries.display();
        }

    }

    public static void displayCountryLastestInput(List<EastAsiaCountries> listCountries) {
        //check list country is empty
        if (listCountries.isEmpty()) {
            System.out.println("COUNTRY IS NOT EXISTED");
            return;
        }
        System.out.format("%-10s %-25s %-20s %-25s\n", "ID", "Name",
                "Total Area", "Terrarin");
        listCountries.get(listCountries.size() - 1).display();
    }

    public static void displayCountriesByAscendingOrder(List<EastAsiaCountries> listCountries) {
        //check list is empty 
        if (listCountries.isEmpty()) {
            System.out.println("COUNTRY IS NOT EXISTED");
            return;
        }

        List<EastAsiaCountries> listSort = new ArrayList<>();
        listSort.addAll(listCountries);

        //sort country by ascending by name
        //Loop run from the first to last listCountries of array 
        for (int i = 0; i < listSort.size(); i++) {

            /*Loop run from first element to the 
            element stand before the last unsorted element */
            for (int j = 0; j < listSort.size() - i - 1; j++) {

                //Compare each pair adjacent elements
                if (listSort.get(j).getCountryName().compareToIgnoreCase(listSort.get(j + 1).getCountryName()) > 0) {
                    EastAsiaCountries temp = listSort.get(j);
                    listSort.set(j, listSort.get(j + 1));
                    listSort.set(j + 1, temp);

                }
            }
        }
        System.out.format("%-10s %-25s %-20s %-25s\n", "ID", "Name",
                "Total Area", "Terrarin");
        //loop from first to last element of listSort
        for (EastAsiaCountries eastAsiaCountries : listSort) {
            eastAsiaCountries.display();
        }

    }

}
