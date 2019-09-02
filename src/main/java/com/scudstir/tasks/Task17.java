package com.scudstir.tasks;

import java.util.Scanner;

public class Task17 {

    /**
     * Вычислить определитель матрицы
     * <a href="https://github.com/elefus/epam-core-04-2018/wiki/Представление-матриц">Представление матриц</a>
     *
     * Формат входных данных:
     * N - целое число (0 < N < 10)
     * N ^ 2 целых чисел (Integer.MIN_VALUE < element < Integer.MAX_VALUE)
     *
     * Формат выходных данных:
     * Целое число, соответствующее определителю матрицы.
     *
     * ---------------------------------------------------------------------------------------------------
     * Примеры выполнения задания:
     *
     * Входные данные:
     *  3
     * -2  1  2
     *  0 -1  0
     *  1 -2  3
     *
     * Выходные данные:
     * 8
     *
     *
     * Входные данные:
     * 4
     * 6 4 0 1
     * 8 7 0 3
     * 1 3 0 9
     * 7 5 1 2
     *
     * Выходные данные:
     * -65
     */

    private  static  int determinant(int [][] matrix){
        int n = matrix.length;
        int result = 0;
        if (n == 1) {
            return 1;
        }
        else if (n == 2){
            result = (matrix [0][0] * matrix [1][1]) - (matrix[1][0]*matrix[0][1]);
            return result;
        }
        for (int i = 0; i <matrix[0].length; i++){
            int [][] temp = new int[matrix.length-1][matrix.length-1];
            for(int j = 1; j < matrix.length; j++) {

                System.arraycopy(matrix[j], 0, temp[j-1], 0, i);

                System.arraycopy(matrix[j], i+1, temp[j-1], i, matrix[0].length-i-1);

            }

            result += matrix[0][i] * Math.pow(-1, i) * determinant(temp);
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число:");
        int n = scanner.nextInt();
        System.out.println("Введите элементы матрицы:");
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int a = 0; a < n; a++) {
                matrix[i][a] = scanner.nextInt();
            }
        }
        System.out.println(determinant(matrix));

    }
}