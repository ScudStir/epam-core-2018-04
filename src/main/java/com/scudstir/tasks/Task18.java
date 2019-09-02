package com.scudstir.tasks;

import java.util.HashSet;
import java.util.Scanner;

public class Task18 {

    /**
     * Найти максимальный элемент(ы) в матрице и удалить из матрицы все строки и столбцы, его содержащие.
     * Гарантируется что после удаления в матрице останется хотя бы один элемент.
     * <a href="https://github.com/elefus/epam-core-04-2018/wiki/Представление-матриц">Представление матриц</a>
     * <p>
     * Формат входных данных:
     * N - целое число (0 < N < 10)
     * N ^ 2 целых чисел (Integer.MIN_VALUE < element < Integer.MAX_VALUE)
     * <p>
     * Формат выходных данных:
     * В результате выполнения задания в выходной поток должна быть выведена преобразованная матрица.
     * Так как матрица в результате преобразования может перестать быть квадратной - несколько изменяется формат её представления:
     * N (целое число) - количество строк
     * M (целое число) - количество столбцов
     * N * M целых чисел, являющихся элементами матрицы
     * <p>
     * ---------------------------------------------------------------------------------------------------
     * Примеры выполнения задания:
     * <p>
     * Входные данные:
     * 3
     * 2  1 -3
     * -2  3  2
     * -1  0  0
     * <p>
     * Выходные данные:
     * 2
     * 2
     * 2 -3
     * -1  0
     * <p>
     * <p>
     * <p>
     * Входные данные:
     * 4
     * 3 -2 -4  1
     * 1  4  4  2
     * -1  0 -3  1
     * 0  2  1  3
     * <p>
     * Выходные данные:
     * 3
     * 2
     * 3  1
     * -1  1
     * 0  3
     */
    private static void printMatrix(int[][] array) {
        for (int[] a : array) {
            for (int b : a) {
                System.out.print(b + "\t");
            }
            System.out.println();
        }
    }


    private static int[][] modifiedMatrix(int[][] array, int value) {
        HashSet<Integer> rowSet = new HashSet<>();
        HashSet<Integer> columnSet = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            for (int n = 0; n < array.length; n++) {
                if (array[i][n] == value) {
                    rowSet.add(i);
                    columnSet.add(n);
                }
            }
        }

        int[][] resultArray = new int[array.length - rowSet.size()][array.length- columnSet.size()];
        int indexRow = 0;
        for (int i = 0; i < array.length; i++) {
            int indexColumn = 0;
            if (rowSet.contains(i)) {
                indexRow++;
            } else {
                for (int n = 0; n < array[i].length; n++) {
                    if (columnSet.contains(n)) {
                        indexColumn++;
                    } else {
                        resultArray[i - indexRow][n - indexColumn] = array[i][n];

                    }
                }
            }
        }
        return resultArray;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число:");
        int n = scanner.nextInt();
        System.out.println("Введите элементы матрицы:");
        int maxValue = Integer.MIN_VALUE;
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int a = 0; a < n; a++) {
                matrix[i][a] = scanner.nextInt();
                if (matrix[i][a] > maxValue) {
                    maxValue = matrix[i][a];
                }
            }
        }
        matrix = modifiedMatrix(matrix, maxValue);
        int rowLength = matrix.length;
        int columnLength = matrix[0].length;
        System.out.println(rowLength + "\n" + columnLength);
        printMatrix(matrix);
    }
}
