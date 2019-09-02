package com.scudstir.tasks;

import java.util.HashSet;
import java.util.Scanner;

public class Task19 {

    /**
     * Уплотнить матрицу, удаляя из нее строки и столбцы, заполненные нулями.
     * Гарантируется что после уплотнения в матрице останется хотя бы один элемент.
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
     * 4
     * 2  0  0 -1
     * 0  0  0  0
     * 0  0  0  3
     * -3  0  0  1
     * <p>
     * Выходные данные:
     * 3
     * 2
     * 2 -1
     * 0  3
     * -3  1
     */
    private static void printMatrix(int[][] array) {
        for (int[] a : array) {
            for (int b : a) {
                System.out.print(b + "\t");
            }
            System.out.println();
        }
    }

    private static int[][] compactedMatrix(int[][] array) {
        HashSet<Integer> rowSet = new HashSet<>();
        HashSet<Integer> columnSet = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i][j] != 0) {
                    rowSet.add(i);
                    columnSet.add(j);
                }
            }
        }
        int[][] resultArray = new int[rowSet.size()][columnSet.size()];
        int rowWithZero = 0;
        for (int i = 0; i < array.length; i++) {
            int columnWithZero = 0;
            if (!rowSet.contains(i)) {
                rowWithZero++;

            }
            else {
                for (int j = 0; j < array.length; j++) {
                    if (!columnSet.contains(j)) {
                        columnWithZero++;
                    } else {
                        resultArray[i - rowWithZero][j - columnWithZero] = array[i][j];

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
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int a = 0; a < n; a++) {
                matrix[i][a] = scanner.nextInt();
            }
        }
        matrix = compactedMatrix(matrix);
        System.out.println(matrix.length);
        System.out.println(matrix[0].length);
        printMatrix(matrix);

    }
}
