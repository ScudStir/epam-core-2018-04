package com.scudstir.tasks;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Task2 {


    /**
     * Ввести N строк с консоли.
     * Упорядочить и вывести строки в порядке возрастания значений их длины.
     * В случае, если длины строк совпадают - упорядочить их в лексикографическом порядке.
     * <p>
     * Формат входных данных:
     * N (целое число, 0 < N < 100) - количество доступных для чтения строк
     * Строка_1
     * Строка_2
     * ...
     * Строка_N
     * <p>
     * Формат выходных данных:
     * В результате выполнения в выходной поток должны быть выведены N строк следующего вида:
     * (длина строки): строка наименьшей длины
     * (длина строки): строка большей длины
     * (длина строки): строка большей длины
     * ...
     * (длина строки): строка наибольшей длины
     * <p>
     * ----------------------------------------------------------------------------------------------
     * Пример выполнения задания:
     * <p>
     * Входные данные:
     * 4
     * Тихо струится река серебристая
     * В царстве вечернем зеленой весны.
     * Солнце садится за горы лесистые.
     * Рог золотой выплывает луны.
     * <p>
     * Выходные данные:
     * (27): Рог золотой выплывает луны.
     * (30): Тихо струится река серебристая
     * (32): Солнце садится за горы лесистые.
     * (33): В царстве вечернем зеленой весны.
     */
    static class Sort implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            if (a.length() < b.length()) {
                return -1;
            } else if (a.length() == b.length()) {
                return a.compareTo(b);
            } else {
                return 1;
            }
        }
    }


    public static void main(String[] args) {
        System.out.println("Введите число строк:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        if (0 < n && n < 100) {
            String[] current = new String[n];
            Scanner scanner1 = new Scanner(System.in);
            for (int a = 0; a < n; a++) {
                current[a] = scanner1.nextLine();
            }
            Arrays.sort(current, new Sort());


            for (String string : current) {
                System.out.println("(" + string.length() + "): " + string);
            }

        } else {
            System.out.println("Вы ввели неверное количество строк");

        }

    }

    // TODO реализация

    // TODO foreach($current : $result) {
    // TODO     System.out.println("(" + current.length() + "): " + current);
    // TODO }
}
