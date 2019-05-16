package com.scudstir.tasks;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Task4 {


    /**
     * Ввести с консоли N слов, состоящих из символов английского алфавита.
     * Найти слово, в котором число различных символов минимально.
     * Символы верхнего и нижнего регистра считать различными.
     * Если таких слов несколько, найти первое из них.
     * <p>
     * Формат входных данных:
     * N (целое число) - количество слов в строке
     * Строка, содержащая указанное количество слов, разделенных пробелами
     * <p>
     * Формат выходных данных:
     * В результате выполнения в выходной поток должно быть выведено слово, содержащее наименьшее число различных символов.
     * <p>
     * -------------------------------------------------------------------------------------------
     * Пример выполнения задания:
     * <p>
     * Входные данные:
     * 4
     * Cake is a lie
     * <p>
     * Выходные данные:
     * a
     */
    // TODO реализация

    // TODO System.out.println(wordWithMinimalNumDiffLetters);Так ч
    static int count(String a) {
        char[] characters = a.toCharArray();
        int letterCount = 1;
        for (int b = 0; b < characters.length; b++) {
            if (b + 1 < characters.length && characters[b] != characters[b + 1]) {
                letterCount++;
            }
            return letterCount;
        }
        return letterCount;
    }

    public static void main(String[] args) {
        System.out.println("Введите число слов:");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println("Введите слова, состоящие из символов английского алфавита:");
        String[] words = new String[num];
        Scanner scanner1 = new Scanner(System.in);
        for (int a = 0; a < num; a++) {
            words[a] = scanner1.next();
        }
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (count(o1) > count(o2)) {
                    return 1;
                } else if (count(o1) < count(o2)) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        String wordWithMinimalNumDiffLetters = words[0];
        System.out.println(wordWithMinimalNumDiffLetters);
        scanner.close();
        scanner1.close();
    }
}







