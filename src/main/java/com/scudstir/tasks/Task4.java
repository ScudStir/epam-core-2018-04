package com.scudstir.tasks;

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
    private static int countLetters(String a) {
        StringBuilder uniqueString = new StringBuilder(String.valueOf(a.charAt(0)));
        for (int b = 1; b < a.length(); b++) {
            String temp = String.valueOf(a.charAt(b));
            if (!uniqueString.toString().contains(temp)) {
                uniqueString.append(temp);
            }
        }
        return uniqueString.length();
    }

    public static void main(String[] args) {
        System.out.println("Введите число слов:");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println("Введите слова, состоящие из символов английского алфавита:");
        Scanner scanner1 = new Scanner(System.in);
        int length = Integer.MAX_VALUE;
        int counter = 0;
        String foundString = "";
        do {
            String temp = scanner1.next();
            int tempLetters = countLetters(temp);
            if (tempLetters < length) {
                length = tempLetters;
                foundString = temp;
            }
            counter++;
        } while (counter < num);


        System.out.println(foundString);
        scanner.close();
        scanner1.close();
    }
}







