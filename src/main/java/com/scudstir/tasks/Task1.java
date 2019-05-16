package com.scudstir.tasks;

import java.util.Scanner;

        /** Ввести N строк с консоли.
                 * Найти среди них самую короткую и самую длинную.
                 * Вывести найденные строки и их длину.
                 * Если строк, удовлетворяющих условию, более одной - вывести последнюю из них.
                 *
                 * Формат входных данных:
                 * N (целое число, 0 < N < 100) - количество доступных для чтения строк
        * Строка_1
        * Строка_2
        * ...
        * Строка_N
        *
        * Формат выходных данных:
        * MIN ($длина_минимальной_строки$): $минимальная_строка$
        * MAX ($длина_максимальной_строки$): $максимальная_строка$
        *
        * -----------------------------------------------------------------------------
        * Пример выполнения задания:
        *
        * Входные данные:
        * 4
        * Унылая пора! Очей очарованье!
        * Приятна мне твоя прощальная краса —
        * Люблю я пышное природы увяданье,
        * В багрец и в золото одетые леса,
        *
        * Выходные данные:
        * MIN (29): Унылая пора! Очей очарованье!
        * MAX (35): Приятна мне твоя прощальная краса —
        */

public class Task1 {
    public static void main(String[] args) {

        System.out.println("Введите число строк:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (0 < n && n < 100) {
            Scanner scanner1 = new Scanner(System.in);
            String minString = scanner1.nextLine();
            String maxString = minString;
            int minLength = minString.length();
            int maxLength = maxString.length();
            for (int a = 0; a < n - 1; a++) {
                String str1 = scanner1.nextLine();
                int str1Length = str1.length();
                if (str1Length <= minLength) {
                    minLength = str1Length;
                    minString = str1;
                }
                if (str1Length >= maxLength) {
                    maxLength = str1Length;
                    maxString = str1;
                }

            }

            System.out.println("MIN (" + minLength + "): " + minString);
            System.out.println("MAX (" + maxLength + "): " + maxString);
            System.out.println(Double.MIN_VALUE);
        } else {
            System.out.println("Вы ввели неверное количество строк");

        }


    }
}