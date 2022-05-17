/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package I21_69loc_ManageCountries52;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class Main {

    public static void main(String[] args) {
        List<EastAsiaCountries> listCountries = new ArrayList<>();
        listCountries.add(new EastAsiaCountries("CN", "China",
                9640011, "Nice"));
        listCountries.add(new EastAsiaCountries("HK", "Hong Kong",
                2204, "Nice"));
        listCountries.add(new EastAsiaCountries("MO", "Macau",
                301, "Nice"));
        listCountries.add(new EastAsiaCountries("JP", "Japan",
                377930, "Complex"));
        listCountries.add(new EastAsiaCountries("MN", "Mongolia",
                1564100, "Complex"));
        listCountries.add(new EastAsiaCountries("NK", "North Korea",
                120538, "Bad"));
        listCountries.add(new EastAsiaCountries("KR", "Korea",
                100210, "Small"));
        listCountries.add(new EastAsiaCountries("TW", "Taiwan",
                36197, "Small"));
        listCountries.add(new EastAsiaCountries("LA", "Laos",
                237955, "Small"));
        while (true) {
            displayMenu();
            int option = GetInput.getInt("Option: ", "It must be digit", 1, 5);
            switch (option) {
                case 1:
                    //Input the information of countries in East Asia
                    ManageEastAsiaCountries.inputCountries(listCountries);
                    break;
                case 2:
                    //Display the information of country you've just input
                    ManageEastAsiaCountries.displayCountryLastestInput(listCountries);
                    break;
                case 3:
                    //Search the information of country by user-entered name
                    ManageEastAsiaCountries.searchCountryByName(listCountries);
                    break;
                case 4:
                    //Display the information of countries sorted name in ascending order  
                    ManageEastAsiaCountries.displayCountriesByAscendingOrder(listCountries);
                    break;
                case 5:
                    System.exit(0);
                    break;
            }
        }
    }

    private static void displayMenu() {
        System.out.println("                        MENU\n"
                + "==========================================================================\n"
                + "1. Input the information of 11 countries in East Asia\n"
                + "2. Display the information of country you've just input\n"
                + "3. Search the information of country by user-entered name\n"
                + "4. Display the information of countries sorted name in ascending order  \n"
                + "5. Exit \n"
                + "==========================================================================");
    }
}
