package com.scudstir.tasks;

import java.util.Scanner;

public class Task15 {
    private static int sum (int [] value){
        int firstPositive = -1;
        int secondPositive = 0;
        int sum = 0;
        for (int i = 0; i<value.length;i++){
            if (value[i] > 0 && firstPositive == -1){
                firstPositive = i;
                continue;

            }
            if (firstPositive >= 0){

                if (value[i] > 0) {
                    secondPositive = i;
                    break;
                }
                else {
                    sum += value[i];
                }
            }

        }
        if (secondPositive == 0){
            return 0;
        }
        return sum;
    }

    /**
     * Найти сумму элементов матрицы, расположенных между первым и вторым положительными значениями в каждой строке.
     * В случае, если в строке нет двух положительных элементов - сумма от этой строки полагается равной нулю.
     * Сумма между двумя рядом расположенными элементами также равна нулю.
     * <a href="https://github.com/elefus/epam-core-04-2018/wiki/Представление-матриц">Представление матриц</a>
     * <p>
     * Формат входных данных:
     * N - целое число (0 < N < 10)
     * N ^ 2 целых чисел (Integer.MIN_VALUE < element < Integer.MAX_VALUE)
     * <p>
     * Формат выходных данных:
     * Целое число, представляющее вычисленную сумму
     * <p>
     * ---------------------------------------------------------------------------------------------------
     * Пример выполнения задания:
     * <p>
     * Входные данные:
     * 3
     * 1   0   3
     * -1   2   2
     * 1  -1   3
     * <p>
     * Выходные данные:
     * -1
     */
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
        int result = 0;
        for (int[] a : matrix) {
            result += sum(a);



            }
        System.out.println(result);
        }
    }
