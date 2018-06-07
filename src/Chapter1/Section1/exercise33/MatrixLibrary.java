package Chapter1.Section1.exercise33;

import java.util.Scanner;

public class MatrixLibrary {

    public static class Matrix {

        static double dot(double[] x, double[] y) {

            double dot = 0;

            // a · b = ax × bx + ay × by
            for (int i = 0; i < x.length; i++) {
                    dot += x[i] * y[i];
            }

            return dot;

        }

        static double[][] mult(double[][] a, double[][] b) {

            if(a != null && b != null) {

                if(a[0].length == b.length) {

                    double mult[][] = new double[a.length][b[0].length];

                    // Fill mult matrix
                    for (int i = 0; i < a.length; i++) //n
                        for (int j = 0; j < b[0].length; j++) // p
                            for (int k = 0; k < a[i].length; k++) // m
                                mult[i][j] += a[i][k] * b[k][j];

                    return mult;

                } else {

                    System.out.printf("Number of columns on 'a' matrix (%d)  are not equal to 'b' matrix (%d)\n", a[0].length, b.length);

                    return null;

                }

            } else {

                System.out.print("Error. Null arrays received. Returning empty array\n");

                return null;

            }

        }

        static double[][] transpose(double[][] a) {

            if(a != null) {

                double transpose[][] = new double[a.length][a[0].length];

                for (int i = 0; i < a.length; i++)
                    for (int j = 0; j < a[0].length; j++)
                        transpose[i][j] = a[j][i];

                return transpose;

            } else {

                return null;

            }

        }

        static double[] mult(double[][] a, double[] x){

            if(a != null && x != null) {

                if(a.length == x.length) {

                    double multi[] = new double[a[0].length];

                    for (int i = 0; i < a[0].length; i++)
                        for (int j = 0; j < a.length; j++)
                            multi[i] += a[j][i] * x[j];

                    return multi;

                } else {

                    System.out.printf("Invalid matrix input. Number of rows in matrix a (%i) does not match number of columns in x (%i)\n", a.length, x.length);

                    return null;

                }

            } else {

                System.out.print("Error. Null arrays received. Returning empty array\n");

                return null;

            }

        }

        static double[] mult(double[] x, double[][] a){

            if(a != null && x != null) {

                if(x.length == a.length) {

                    double multi[] = new double[x.length];

                    for (int i = 0; i < a[0].length; i++)
                        for (int j = 0; j < a.length; j++)
                            multi[i] += a[j][i] * x[j];

                    return multi;

                } else {

                    System.out.printf("Invalid matrix input. Number of rows in matrix a (%i) does not match number of columns in x (%i)\n", a.length, x.length);

                    return null;

                }

            } else {

                System.out.print("Error. Null matrix received. Returning empty matrix\n");

                return null;

            }

        }

    }

    public static void menu() {

        Matrix matrix = new Matrix();               // Initialize matrix class
        Scanner reader = new Scanner(System.in);    // To read from System.in
        int option = 0;

        while(option != 6) {

            System.out.print("Select one of the following options\n");
            System.out.print("1.- Vector dot product\n");
            System.out.print("2.- Matrix-matrix product\n");
            System.out.print("3.- Transpose\n");
            System.out.print("4.- Matrix-vector product\n");
            System.out.print("5.- Vector-matrix product\n");
            System.out.print("6.- Exit\n");

            System.out.print("Option: ");
            option = Integer.parseInt(reader.nextLine());

            if(option < 1 || option > 6)
                System.out.print("Invalid option selected\n ");

            switch(option) {

                case 1:
                    dot(matrix);
                    break;
                case 3:
                    transpose(matrix);
                    break;
                case 2:
                case 4:
                case 5:
                    mult(matrix, option);
                    break;

            }

        }

    }

    static void dot(Matrix matrix) {

        double dotXMatrix[] = makeMatrix(matrixSize(1)[1]);     // By referring to the [1] element in matrixSize we get the number of columns
        System.out.print("Assigning the values of the first matrix\n");
        dotXMatrix = assignMatrixValues(dotXMatrix);
        double dotYMatrix[] = makeMatrix(dotXMatrix.length);
        System.out.print("Assigning the values of the second matrix\n");
        dotYMatrix = assignMatrixValues(dotYMatrix);

        System.out.printf("The vector dot product is: %s\n", Double.toString(matrix.dot(dotXMatrix, dotYMatrix)));

    }

    static void transpose(Matrix matrix) {

        double transpose[][] = makeMatrix(matrixSize(2));
        System.out.print("Assigning the values of the matrix\n");
        transpose = assignMatrixValues(transpose);

        System.out.print("Matrix \n");
        printMatrix(transpose);
        System.out.print("Transpose matrix \n");
        printMatrix(matrix.transpose(transpose));

    }

    static void mult(Matrix matrix, int option) {

        double a[][];

        switch(option){

            case 2:
                System.out.print("Matrix a\n");
                a = makeMatrix(matrixSize(2));
                a = assignMatrixValues(a);
                System.out.print("Matrix b\n");
                double b[][] = makeMatrix(matrixSize(2));
                b = assignMatrixValues(b);

                System.out.print("Matrix a\n");
                printMatrix(a);
                System.out.print("Matrix a\n");
                printMatrix(b);
                System.out.print("Matrix-matrix product\n");
                printMatrix(matrix.mult(a,b));
                break;

            case 4:
                System.out.print("Matrix a\n");
                a = makeMatrix(matrixSize(2));
                a = assignMatrixValues(a);
                System.out.print("Matrix x\n");
                double x[] = makeMatrix(matrixSize(1)[1]);
                x = assignMatrixValues(x);

                System.out.print("Matrix a\n");
                printMatrix(a);
                System.out.print("Matrix x\n");
                printMatrix(x);
                System.out.print("Matrix-vector product\n");
                printMatrix(matrix.mult(a,x));
                break;

            case 5:
                System.out.print("Matrix y\n");
                double y[] = makeMatrix(matrixSize(1)[1]);
                y = assignMatrixValues(y);
                System.out.print("Matrix a\n");
                a = makeMatrix(matrixSize(2));
                a = assignMatrixValues(a);

                System.out.print("Matrix y\n");
                printMatrix(y);
                System.out.print("Matrix a\n");
                printMatrix(a);
                System.out.print("Vector-matrix product\n");
                printMatrix(matrix.mult(y,a));
                break;

        }

    }

    static int[] matrixSize(int matrixOption) {

        int matrixSize[];
        int rows = 0;
        int columns = 0;

        System.out.printf("Enter the dimensions of the matrix \n");

        switch(matrixOption) {

            case 1:
                rows = 1;
                columns = getColumnsAndRows("Columns");
                break;
            case 2:
                rows = getColumnsAndRows("Rows");
                columns = getColumnsAndRows("Columns");
                break;

        }

        matrixSize = new int[]{rows, columns};

        return matrixSize;

    }

    static double[][] makeMatrix(int size[]){

        if (size != null) {

            int rows = size[0];
            int columns = size[1];

            double matrix[][] = new double[rows][columns];

            return matrix;

        } else {

            System.out.print("Error. Received null size of matrix");

            return null;

        }

    }

    static double[] makeMatrix(int size){

        if (size != 0) {

            int columns = size;

            double matrix[] = new double[columns];

            return matrix;

        } else {

            System.out.print("Error. Received null size of matrix");

            return null;

        }

    }

    static double[][] assignMatrixValues(double matrix[][]) {

        Scanner reader = new Scanner(System.in);

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[0].length; j++) {

                System.out.printf("Enter the value for the corresponding matrix position (%d,%d): ", i+1, j+1);
                matrix[i][j] = Double.parseDouble(reader.nextLine());

            }

        }

        return matrix;

    }

    static double[] assignMatrixValues(double matrix[]) {

        Scanner reader = new Scanner(System.in);

        for (int i = 0; i < matrix.length; i++) {

            System.out.printf("Enter the value ot the column number %d: ", i + 1);
            matrix[i] = Double.parseDouble(reader.nextLine());

        }

        return matrix;

    }

    static int getColumnsAndRows(String text) {

        Scanner reader = new Scanner(System.in);
        int size = 0;

        while(size < 1) {

            System.out.printf("%s: ", text);

            size = Integer.parseInt(reader.nextLine());

            if (size < 1)
                System.out.print("Size can not be lower than 1");

        }

        return size;

    }

    static void printMatrix(double a[][]){

        if(a != null) {

            for (int i = 0; i < a[0].length; i++) {
                System.out.print("|");
                for (int j = 0; j < a.length; j++) {
                    System.out.printf("%2.2f|", a[i][j]);
                }
                System.out.print("\n");
            }

        } else {

            System.out.print("Error. Null matrix received. Returning empty matrix\n");

        }

    }

    static void printMatrix(double a[]){

        if(a != null) {

            for (int i = 0; i < a.length; i++) {
                System.out.print("|");
                System.out.printf("%2.2f|", a[i]);
            }

            System.out.print("\n");

        } else {

            System.out.print("Error. Null matrix received. Returning empty matrix\n");

        }

    }

    public static void main(String args[]) {

        menu();

    }

}