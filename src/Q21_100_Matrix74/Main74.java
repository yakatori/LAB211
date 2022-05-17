/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q21_100_Matrix74;

/**
 *
 * @author admin
 */
public class Main74 {
    public static void main(String[] args) {
        //loop until user want to quit
        while (true) {          
            int choice = Matrix.displayMenu();
           switch(choice){
               //1. Addition Matrix
               case 1: 
                   Matrix.addMatrix();
                   break;
               //2. Subtraction Matrix
               case 2:
                   Matrix.subMatrix();
                   break;
               //3. Multiplication Matrix 
               case 3:
                    Matrix.Mutiplication();
                    break;
               //4. Quit 
               case 4:
                    return;
           }
            
        }
    }
}
