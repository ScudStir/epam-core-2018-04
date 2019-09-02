package com.scudstir.tasks;

import java.util.Scanner;

public class Task20 {

    /**
     * Найти в матрице минимальный элемент и переместить его в указанное место путем перестановки строк и столбцов.
     * Гарантируется, что минимальный элемент в матрице встречается ровно один раз.
     * <a href="https://github.com/elefus/epam-core-04-2018/wiki/Представление-матриц">Представление матриц</a>
     * <p>
     * Формат входных данных:
     * X (целое число, 0 <= X < N) - номер строки
     * Y (целое число, 0 <= Y < N) - номер столбца
     * N - целое число (0 < N < 10)
     * N ^ 2 целых чисел (Integer.MIN_VALUE < element < Integer.MAX_VALUE)
     * <p>
     * Формат выходных данных:
     * Матрица после выполнения преобразования
     * <p>
     * ---------------------------------------------------------------------------------------------------
     * Примеры выполнения задания:
     * <p>
     * Входные данные:
     * 1
     * 2
     * 4
     * 2  4 -2 -3
     * 0  1  3 -1
     * -1  0  2  3
     * -2  1 -1  4
     * <p>
     * Выходные данные:
     * 4
     * 0  1 -1  3
     * 2  4 -3 -2
     * -1  0  3  2
     * -2  1  4 -1
     */

    private static void swapMinValueInMatrix(int[][] array, int minIndexRow, int minIndexCol, int swapIndexRow, int swapIndexCol) {
        int[] temp = array[swapIndexRow];
        array[swapIndexRow] = array[minIndexRow];
        array[minIndexRow] = temp;
        for (int i = 0; i < array.length; i++) {
            int tmp = array[i][swapIndexCol];
            array[i][swapIndexCol] = array[i][minIndexCol];
            array[i][minIndexCol] = tmp;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер строки и столбца:");
        int rowNumber = scanner.nextInt();
        int columnNumber = scanner.nextInt();
        System.out.println("Введите размер матрицы:");
        int n = scanner.nextInt();
        System.out.println("Введите элементы матрицы:");
        int minRow = 0;
        int minColumn = 0;
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
                if (matrix[i][j] < matrix[minRow][minColumn]) {
                    minRow = i;
                    minColumn = j;

                }
            }
        }
        swapMinValueInMatrix(matrix, minRow, minColumn, rowNumber, columnNumber);
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] a : matrix) {
            for (int b : a) {
                System.out.print(b + "\t");
            }
            System.out.println();
        }
    }
}