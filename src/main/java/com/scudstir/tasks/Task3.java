package com.scudstir.tasks;

import java.util.Scanner;

public class Task3 {

    /**
     * Ввести N строк с консоли.
     * Вывести те строки, длина которых меньше средней.
     * Под 'средней' подразумевается среднеарифметическая величина длины всех строк, округленная до целого в меньшую сторону.
     * <p>
     * Формат входных данных:
     * N (целое число) - количество доступных для чтения строк
     * N строк
     * <p>
     * Формат выходных данных:
     * В результате выполнения в выходной поток должна быть выведена средняя длина (округленная до целого в меньшую сторону) и строки, удовлетворяющие условию.
     * Порядок появления строк в выходном потоке должен совпадать с порядком их появления во входном.
     * <p>
     * AVERAGE (средняя длина)
     * (длина строки): строка с длиной меньше средней
     * ...
     * (длина строки): строка с длиной меньше средней
     * <p>
     * ------------------------------------------------------------------------------------------------
     * Пример выполнения задания:
     * <p>
     * Входные данные:
     * 5
     * Послушайте!
     * Ведь, если звезды зажигают -
     * Значит - это кому-нибудь нужно?
     * Значит - кто-то хочет, чтобы они были?
     * Значит - кто-то называет эти плевочки жемчужиной?
     * <p>
     * Выходные данные:
     * AVERAGE (31)
     * (11): Послушайте!
     * (28): Ведь, если звезды зажигают -
     */
    public static void main(String[] args) {
        System.out.println("Введите число строк:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] strings = new String[n];
        Scanner scanner1 = new Scanner(System.in);
        int sum = 0;
        for (int a = 0; a < n; a++) {
            strings[a] = scanner1.nextLine();
            sum += strings[a].length();
        }
        int averageLength = sum / n;
        System.out.println("AVERAGE (" + averageLength + ")");
        for (String current : strings) {
            if (current.length() < averageLength) {
                System.out.println("(" + current.length() + "): " + current);
            }
        }
        // TODO реализация

        // TODO System.out.println("AVERAGE (" + averageLength + ")");
        // TODO foreach($current : $result) {
        // TODO     System.out.println("(" + current.length() + "): " + current);
        // TODO }
    }
}