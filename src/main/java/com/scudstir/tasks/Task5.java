package com.scudstir.tasks;

import java.util.Scanner;

public class Task5 {

    /**
     * Ввести N слов с консоли.
     * Найти количество слов, содержащих только символы латинского алфавита, а среди них – количество слов с равным числом гласных и согласных букв.
     * <p>
     * Формат входных данных:
     * N (целое число) - количество слов в строке
     * Строка, содержащая указанное количество слов, разделенных пробелами
     * <p>
     * Формат выходных данных:
     * В результате выполнения в выходной поток должно быть выведено количество слов, состоящих только из символов латинского алфавита и содержащих равное количество гласных и согласных букв.
     * Количество различных вхождений одной буквы в слове учитывается.
     * <p>
     * ---------------------------------------------------------------------------------------------------
     * Пример выполнения задания:
     * <p>
     * Входные данные:
     * 5
     * Язык программирования Java is widespread
     * <p>
     * Выходные данные:
     * 2
     */
    public static void main(String[] args) {
        System.out.println("Введите количество слов:");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println("Введите строку:");
        Scanner scanner1 = new Scanner(System.in);
        int wordCount = 0;
        for (int a = 0; a < num; a++) {
            String string = scanner1.next();
            if (string.matches("[a-zA-Z]*")) {
                int consonantCount = string.length() - string.replaceAll("[aeyuioAEYUIO]", "").length();
                int vowelCount = string.length() - consonantCount;
                if (vowelCount == consonantCount) {
                    wordCount++;
                }
            }
        }
        System.out.println(wordCount);
    }
}