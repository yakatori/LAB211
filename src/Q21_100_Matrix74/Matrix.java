/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q21_100_Matrix74;

import java.util.Scanner;

/**
 *
 * @author admin
 */
class Matrix {

        public static int getInt(String msgString, String errorString,
            int min, int max) {
        Scanner scanner = new Scanner(System.in);

        // ask user until true input
        while (true) {
            System.out.print(msgString);
            try {
                String input = scanner.nextLine().trim();
                //if input is empty or have only space => tell user
                if (input.isEmpty()) {
                    System.out.println("Input can't be empty!!!");
                } else {
                    int number = Integer.parseInt(input);
                    // check the range of input
                    if (min <= number && number <= max) {
                        return number;
                    } else {
                        System.out.println("Invalid. The input must be "
                                + "in range " + min + " to " + max);
                    }
                }

            } catch (NumberFormatException e) {
                System.out.println(errorString);
            }
        }

    }

    public static int displayMenu() {
        System.out.println(" ======Calculation======");
        System.out.println("1. Addition Matrix");
        System.out.println("2. Subtraction Matrix");
        System.out.println("3. Multiplication Matrix");
        System.out.println("4. Quit");
        return getInt("Your choice:", "Please enter integer number", 1, 4);

    }

    public static boolean checkRowCol(int a, int b) {
        //check number
        if (a == b) {
            return true;
        }
        return false;
    }

    public static void inputValueMatrix(int[][] matrix, int id) {
        int row = matrix.length;
        int col = matrix[0].length;
        //loop run from first to last element of row
        for (int i = 0; i < row; i++) {
            int a = i + 1;
            //loop run from first to last element of column
            for (int j = 0; j < col; j++) {
                int b = j + 1;
                matrix[i][j] = getInt("Enter Matrix" + id + "[" + a + "]" + "[" + b + "]:", 
                        "Value of matrix is digit", Integer.MIN_VALUE, Integer.MAX_VALUE);
            }
        }

    }

    public static void displayMatrix(int[][] matrix, int id) {
        int row = matrix.length;
        int col = matrix[0].length;
        //loop run from first to last element of row
        for (int i = 0; i < row; i++) {
            //loop run from first to last element of column
            for (int j = 0; j < col; j++) {
                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println("");
        }

    }

    public static void addMatrix() {
        System.out.println("--------- Addition ------------");
        int row, col, row2, col2;
        row = getInt("Enter Row Matrix 1:", "Value of matrix is digit", 1, Integer.MAX_VALUE);
        col = getInt("Enter Column Matrix 1:", "Value of matrix is digit", 1, Integer.MAX_VALUE);
        int[][] matrix1 = new int[row][col];
        inputValueMatrix(matrix1, 1);
        //Loop to check input until it falses 
        while (true) {
            row2 = getInt("Enter Row Matrix 2:", "Value of matrix is digit", 1, Integer.MAX_VALUE);
            //check row of matrix1 = row of matrix2, true => continue program, else re-enter
            if (checkRowCol(row, row2)) {
                break;
            } else {
                System.out.println("Please enter again! Row Matrix 2 must equal to Row Matrix 1");
            }
        }
        //Loop to check input until it falses 
        while (true) {
            col2 = getInt("Enter Column Matrix 2:", "Value of matrix is digit", 1, Integer.MAX_VALUE);
            //check column of matrix1 = column of matrix2, true => continue program, else re-enter
            if (checkRowCol(col, col2)) {
                break;
            } else {
                System.out.println("Please enter again! Column Matrix 2 must equal to Column Matrix 1");
            }
        }

        int[][] matrix2 = new int[row2][col2];
        inputValueMatrix(matrix2, 2);

        int[][] Matrix3 = new int[row][col];

        //loop run from first to last element of row matrix1 = row matrix2
        for (int i = 0; i < row; i++) {
            //loop run from first to last element of column matrix1 = column matrix2
            for (int j = 0; j < col; j++) {
                Matrix3[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        System.out.println("--------- Result ------------");
        displayMatrix(matrix1, 1);
        System.out.println("+");
        displayMatrix(matrix2, 2);
        System.out.println("=");
        displayMatrix(Matrix3, 3);
    }

    public static void subMatrix() {
        System.out.println("--------- Subtraction ------------");
        int row1, col1, row2, col2;
        row1 = getInt("Enter Row Matrix 1:", "Value of matrix is digit", 1, Integer.MAX_VALUE);
        col1 = getInt("Enter Column Matrix 1:", "Value of matrix is digit", 1, Integer.MAX_VALUE);
        int[][] matrix1 = new int[row1][col1];

        inputValueMatrix(matrix1, 1);
        while (true) {
            row2 = getInt("Enter Row Matrix 2:", "Value of matrix is digit", 1, Integer.MAX_VALUE);
            //check row of matrix1 = row of matrix2, true => continue program, else re-enter
            if (checkRowCol(row1, row2)) {
                break;
            } else {
                System.out.println("Please enter again! Row Matrix 2 must equal to Row Matrix 1");
            }
        }
        while (true) {
            col2 = getInt("Enter Column Matrix 2:", "Value of matrix is digit", 1, Integer.MAX_VALUE);
            //check column of matrix1 = column of matrix2, true => continue program, else re-enter
            if (checkRowCol(col1, col2)) {
                break;
            } else {
                System.out.println("Please enter again! Column Matrix 2 must equal to Column Matrix 1");
            }
        }

        int[][] matrix2 = new int[row2][col2];

        inputValueMatrix(matrix2, 2);

        int[][] Matrix3 = new int[row1][col1];

        //loop run from first to last element of row matrix1 = row matrix2
        for (int i = 0; i < row1; i++) {
            //loop run from first to last element of column matrix1 = column matrix2
            for (int j = 0; j < col1; j++) {
                Matrix3[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        System.out.println("--------- Result ------------");
        displayMatrix(matrix1, 1);
        System.out.println("-");
        displayMatrix(matrix2, 2);
        System.out.println("=");
        displayMatrix(Matrix3, 3);
    }

    public static void Mutiplication() {
        System.out.println("--------- Multiplication ------------");
        int row1, col1, row2, col2;
        row1 = getInt("Enter Row Matrix 1:", "Value of matrix is digit", 1, Integer.MAX_VALUE);
        col1 = getInt("Enter Column Matrix 1:", "Value of matrix is digit", 1, Integer.MAX_VALUE);
        int[][] matrix1 = new int[row1][col1];

        inputValueMatrix(matrix1, 1);
        while (true) {
            row2 = getInt("Enter Row Matrix 2:", "Value of matrix is digit", 1, Integer.MAX_VALUE);
            //check column of matrix1 = row of matrix2, true => continue program, else re-enter
            if (checkRowCol(col1, row2)) {
                break;
            } else {
                System.out.println("Please enter again! Row Matrix 2 must equal to Column Matrix 1");
            }
        }
        col2 = getInt("Enter Column Matrix 2:", "Value of matrix is digit", 1, Integer.MAX_VALUE);
        int[][] matrix2 = new int[row2][col2];
        inputValueMatrix(matrix2, 2);

        int[][] Matrix3 = new int[row1][col2];
        //loop run from first to last element of row matrix1
        for (int i = 0; i < row1; i++) {
            //loop run from first to last element of column matrix2
            for (int j = 0; j < col2; j++) {
                int value = 0;
                //loop run from first to last element of column matrix1= row matrix2
                for (int k = 0; k < col1; k++) {
                    value += matrix1[i][k] * matrix2[k][j];
                }
                Matrix3[i][j] = value;
            }
        }
        System.out.println("--------- Result ------------");
        displayMatrix(matrix1, 1);
        System.out.println("*");
        displayMatrix(matrix2, 2);
        System.out.println("=");
        displayMatrix(Matrix3, 3);
    }
}
