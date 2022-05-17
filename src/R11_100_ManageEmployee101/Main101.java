/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package R11_100_ManageEmployee101;

/**
 *
 * @author admin
 */
public class Main101 {

    public static void main(String[] args) {

        ViewEmployee view = new ViewEmployee();
        view.addEmp(new Employee(1, "mai", "anh", "0123456789", "a@gmail.com", "Ha Noi", "11/11/2000", 0, 2000, "FPT"));
        view.addEmp(new Employee(2, "mai", "ban", "0213456789", "b@fpt.edu.vn", "Ha Nam", "21/12/2001", 1, 1000, "VNG"));
        view.addEmp(new Employee(3, "chien", "thang", "0312456789", "c@gmail.com", "Bac Giang", "15/1/2000", 1, 400, "FPT"));
        view.addEmp(new Employee(4, "lam", "dung", "0432156789", "d@gmail.com", "Ha Noi", "19/5/2000", 1, 3000, "FPT"));

        while (true) {
            displayMenu();
            int option = GetInput.getInt("Enter option: ", "It must be digit", 1, 6);
            switch (option) {
                case 1:
                    //input employee
                    view.inputEmployee();
                    break;
                case 2:
                    //update employee
                    view.updateEmployee();
                    break;
                case 3:
                    //remove employee
                    view.removeEmployee();
                    break;
                case 4:
                    //search
                    view.search();
                    break;
                case 5:
                    //sort
                    view.sort();
                    break;
                case 6:
                    System.exit(0);
                    break;
            }
        }
    }

    private static void displayMenu() {
        System.out.println("====================== Menu ======================");
        System.out.println("1.	Add employees \n"
                + "2.	Update employees\n"
                + "3.	Remove employees\n"
                + "4.	Search employees\n"
                + "5.	Sort employees by salary\n"
                + "6.	Exit\n"
                + "");

    }

}
