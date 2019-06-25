package com.scudstir.tasks;

import java.util.Scanner;

public class Task13 {
    private static void printMatrix(int[][] array) {
        for (int[] a : array) {
            for (int b : a) {
                System.out.print(b + "\t");
            }
            System.out.println();
        }
    }

    private static int[][] shift(int[][] array, int k) {
        int realShift = k % array.length;
        if (realShift > 0) {
            int[][] shiftArray = new int[array.length][];
            int shiftDown = array.length - realShift;
            System.arraycopy(array, shiftDown, shiftArray, 0, realShift);
            System.arraycopy(array, 0, shiftArray, realShift, shiftDown);
            return shiftArray;


        } else if (realShift < 0) {
            realShift = Math.abs(realShift);
            int[][] shiftArray = new int[array.length][];
            int shiftUp = array.length - realShift;
            System.arraycopy(array, realShift, shiftArray, 0, shiftUp);
            System.arraycopy(array, 0, shiftArray, shiftUp, realShift);
            return shiftArray;

        } else {
            return array;
        }
    }

    /**
     * Ввести матрицу с консоли.
     * Выполнить циклический сдвиг матрицы на k позиций:
     * k > 0 - сдвиг матрицы вниз
     * k < 0 - сдвиг матрицы вверх
     * k = 0 - матрица остается без изменений
     * <a href="https://github.com/elefus/epam-core-04-2018/wiki/Представление-матриц">Представление матриц</a>
     * <p>
     * Формат входных данных:
     * N - целое число (0 < N < 10)
     * N ^ 2 целых чисел (Integer.MIN_VALUE < element < Integer.MAX_VALUE)
     * k - целое число (0 <= k <= 100)
     * <p>
     * Формат выходных данных:
     * Матрица после выполнения преобразования
     * <p>
     * ---------------------------------------------------------------------------------------------------
     * Примеры выполнения задания:
     * <p>
     * Входные данные:
     * 3
     * 4   2   3
     * 1   0  -3
     * 0  -1   2
     * -2
     * <p>
     * Выходные данные:
     * 3
     * 0  -1   2
     * 4   2   3
     * 1   0  -3
     * <p>
     * <p>
     * <p>
     * Входные данные:
     * 3
     * 4   2   3
     * 1   0  -3
     * 0  -1   2
     * 0
     * <p>
     * Выходные данные:
     * 3
     * 4   2   3
     * 1   0  -3
     * 0  -1   2
     */
    public static void main(String[] args) {
        System.out.println("Введите число строк:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println("Введите матрицу:");
        int[][] elements = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int a = 0; a < n; a++) {
                elements[i][a] = scanner.nextInt();
            }
        }
        System.out.println("Введите номер столбца:");
        int k = scanner.nextInt();
        elements = shift(elements, k);
        printMatrix(elements);
    }
}