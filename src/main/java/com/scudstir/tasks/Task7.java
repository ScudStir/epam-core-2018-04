package com.scudstir.tasks;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Task7 {
    private static boolean isResult(String string) {
        if (string.matches("[a-zA-Z]*")) {
            char[] chars = string.toLowerCase().toCharArray();
            HashSet<Character> set = new HashSet<>();
            for (char aChar : chars) {
                if (!set.add(aChar)) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }

    }

    private static boolean addIgnoreCase(String str, LinkedHashSet<String> set) {
        for (String s : set) {
            if (str.equalsIgnoreCase(s)) {
                return false;
            }
        }
        return true;
    }


    /**
     * Ввести N слов с консоли.
     * Найти слова, состоящие только из различных символов английского алфавита.
     * Символы верхнего и нижнего регистра считать одинаковыми.
     * В случае, если слово встречается более одного раза - вывести его единожды.
     * <p>
     * Формат входных данных:
     * N (целое число, 0 < N < 100) - количество слов в строке
     * Строка, содержащая нимимум N слов (состоящих только из букв английского языка), разделенных пробелами
     * <p>
     * Формат выходных данных:
     * В результате выполнения в выходной поток должна быть выведена строка, содержащая найденные слова, разделенные пробелами.
     * Порядок слов должен совпадать с порядком их появления во входной последовательности.
     * В случае, если не найдено ни одного слова, удовлетворяющего условию - в поток должно быть выведено "NOT FOUND".
     * <p>
     * ---------------------------------------------------------------------------------------------------
     * Пример выполнения задания:
     * <p>
     * Входные данные:
     * 11
     * The Java programming language is a general-purpose, concurrent, class-based, object-oriented language
     * <p>
     * Выходные данные:
     * The is a
     */
    public static void main(String[] args) {
        System.out.println("Введите количество слов:");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println("Введите строку:");
        Scanner scanner1 = new Scanner(System.in);
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        for (int i = 0; i < num; i++) {
            String string = scanner1.next();
            if (isResult(string) && addIgnoreCase(
                    string, linkedHashSet
            )) {
                linkedHashSet.add(string);
            }
        }


        if (linkedHashSet.isEmpty()) {
            System.out.println("NOT FOUND");
        } else {
            for (String str : linkedHashSet) {
                System.out.print(str + " ");
            }
        }
    }
}