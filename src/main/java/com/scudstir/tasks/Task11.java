package com.scudstir.tasks;

import java.util.Scanner;

public class Task11 {
    private static int sumOfValue(int a) {
        if (a < 10) {
            return a;
        } else {
            return a % 10 + sumOfValue(a / 10);

        }
    }
    /**
     * Ввести число с консоли.
     * С использованием рекурсии вычислить сумму цифр, из которых составлено указанное число.
     *
     * Формат входных данных:
     * value - целое число, лежащее в диапазоне [Integer.MIN_VALUE, Integer.MAX_VALUE]
     *
     * Формат выходных данных:
     * sum - сумма цифр, составляющих исходное число
     *
     * ---------------------------------------------------------------------------------------------------
     * Примеры выполнения задания:
     *
     * Входные данные:
     * 25593
     *
     * Выходные данные:
     * 24
     *
     *
     * Входные данные:
     * -50
     *
     * Выходные данные:
     * 5
     */
    public static void main(String[] args) {
        System.out.println("Введите число:");
        Scanner scanner = new Scanner(System.in);
        int value = Math.abs(scanner.nextInt());
        int sum = sumOfValue(value);
        System.out.println(sum);

    }
}