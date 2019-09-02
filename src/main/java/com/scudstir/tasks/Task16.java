package com.scudstir.tasks;

import java.util.Scanner;

public class Task16 {

    /**
     * Выполнить поворот матрицы на указанное количество градусов по часовой или против часовой стрелки.
     * Градусы задаются целочисленным значением degrees.
     * switch(degrees) {
     * ...
     * case  -5: поворот на 450* против часовой стрелки
     * case  -4: поворот на 360* против часовой стрелки
     * case  -3: поворот на 270* против часовой стрелки
     * case  -2: поворот на 180* против часовой стрелки
     * case  -1: поворот на  90* против часовой стрелки
     * case   0: поворот не осуществляется
     * case   1: поворот на  90* по     часовой стрелке
     * case   2: поворот на 180* по     часовой стрелке
     * case   3: поворот на 270* по     часовой стрелке
     * case   4: поворот на 360* по     часовой стрелке
     * case   5: поворот на 450* по     часовой стрелке
     * ...
     * }
     * <a href="https://github.com/elefus/epam-core-04-2018/wiki/Представление-матриц">Представление матриц</a>
     * <p>
     * Формат входных данных:
     * N - целое число (0 < N < 10)
     * N ^ 2 целых чисел (Integer.MIN_VALUE < element < Integer.MAX_VALUE)
     * degrees - целое число (-100 <= k <= 100)
     * <p>
     * Формат выходных данных:
     * Матрица после выполнения преобразования
     * <p>
     * ---------------------------------------------------------------------------------------------------
     * Примеры выполнения задания:
     * <p>
     * Входные данные:
     * 3
     * 1  -2   1
     * -3   0   2
     * 3  -2   1
     * 1
     * <p>
     * Выходные данные:
     * 3
     * 3  -3   1
     * -2   0  -2
     * 1   2   1
     * <p>
     * <p>
     * <p>
     * Входные данные:
     * 2
     * 9  3
     * 2  4
     * -2
     * <p>
     * Выходные данные:
     * 2
     * 4 2
     * 3 9
     */
    private static void printMatrix(int[][] array) {
        for (int[] a : array) {
            for (int b : a) {
                System.out.print(b + "\t");
            }
            System.out.println();
        }
    }

    private static int[][] rotateClockwise(int[][] array) {
        int n = array.length;
        int[][] rotateArray = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                rotateArray[k][i] = array[n - i - 1][k];

            }
        }
        return rotateArray;

    }

    private static int[][] rotateCounterclockwise(int[][] array) {
        int n = array.length;
        int[][] rotateArray = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                rotateArray[k][i] = array[i][n - k - 1];

            }
        }
        return rotateArray;

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
        System.out.println("Введите значение для поворота:");
        int degrees = scanner.nextInt();
        switch (degrees) {

            case -5:
                matrix = rotateCounterclockwise(matrix);
                printMatrix(matrix);
                break;
            case -4:
                printMatrix(matrix);
                break;
            case -3:
                matrix = rotateClockwise(matrix);
                printMatrix(matrix);
                break;
            case -2:
                matrix = rotateCounterclockwise(rotateCounterclockwise(matrix));
                printMatrix(matrix);
                break;
            case -1:
                matrix = rotateCounterclockwise(matrix);
                printMatrix(matrix);
                break;
            case 0:
                printMatrix(matrix);
                break;
            case 1:
                matrix = rotateClockwise(matrix);
                printMatrix(matrix);
                break;
            case 2:
                matrix = rotateClockwise(rotateClockwise(matrix));
                printMatrix(matrix);
                break;
            case 3:
                matrix = rotateCounterclockwise(matrix);
                printMatrix(matrix);
                break;
            case 4:
                printMatrix(matrix);
                break;
            case 5:
                matrix = rotateClockwise(matrix);
                printMatrix(matrix);
                break;
        }
    }
}