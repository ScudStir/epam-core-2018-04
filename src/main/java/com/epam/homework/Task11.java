package com.epam.homework;

import java.util.Scanner;

public class Task11 {

    /**
     * Ввести число с консоли.
     * С использованием рекурсии вычислить сумму цифр, из которых составлено указанное число.
     * <p>
     * Формат входных данных:
     * value - целое число, лежащее в диапазоне [Integer.MIN_VALUE, Integer.MAX_VALUE]
     * <p>
     * Формат выходных данных:
     * sum - сумма цифр, составляющих исходное число
     * <p>
     * ---------------------------------------------------------------------------------------------------
     * Примеры выполнения задания:
     * <p>
     * Входные данные:
     * 25593
     * <p>
     * Выходные данные:
     * 24
     * <p>
     * <p>
     * Входные данные:
     * -50
     * <p>
     * Выходные данные:
     * 5
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int value = Math.abs(scanner.nextInt());

        System.out.println(sumOfNumbers(value));
    }

    private static int sumOfNumbers(int value) {
        if (value / 10 == 0) {
            return value;
        }
        return ((value % 10) + sumOfNumbers(value / 10));
    }
}