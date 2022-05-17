/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package I21_69loc_ManageCountries52;

/**
 *
 * @author admin
 */
public class EastAsiaCountries extends Country {

    private String countryTerrain;

    public EastAsiaCountries() {
        super();
    }

    public EastAsiaCountries(String countryCode, String countryName,
                float totalArea, String countryTerrain) {
        super(countryCode, countryName, totalArea);
        this.countryTerrain = countryTerrain;
    }

    public String getCountryTerrain() {
        return countryTerrain;
    }

    public void setCountryTerrain(String countryTerrain) {
        this.countryTerrain = countryTerrain;
    }

    public void display() {
        System.out.format("%-10s %-25s %-20s %-25s\n", countryCode, countryName,
                totalArea, countryTerrain);
    }

}
