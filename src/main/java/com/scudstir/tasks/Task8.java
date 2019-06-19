package com.scudstir.tasks;

import java.util.ArrayList;
import java.util.Scanner;

public class Task8 {
    private static boolean isNumber(String str) {
        return str.matches("[0-9]*");
    }

    private static boolean isPalindrome(String str) {
        int length = str.length();
        for (int i = 0; i < length / 2; i++) {
            if (str.charAt(i) != str.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;

    }

    /**
     * Ввести N слов с консоли.
     * Помимо обычных слов, во входной последовательности могут встречаться целые числа (в том числе большие чем Long.MAX_VALUE).
     * Среди них необходимо найти число-палиндром (одинаково читающееся в обоих направлениях).
     * Число, содержащее одну цифру также является палиндромом.
     * Если палиндромов во входной последовательности больше одного - найти второй уникальный из них.
     * <p>
     * Формат входных данных:
     * N (целое число, 0 < N < 100) - количество слов в строке
     * Строка, содержащая минимум N слов, разделенных пробелами
     * <p>
     * Формат выходных данных:
     * В результате выполнения в выходной поток должно быть выведено найденное число-палиндром.
     * В случае, если не найдено ни одного палиндрома - в поток должно быть выведено "NOT FOUND".
     * <p>
     * ---------------------------------------------------------------------------------------------------
     * Пример выполнения задания:
     * <p>
     * Входные данные:
     * 15
     * Chapter 11 describes exceptions, chapter 13 describes binary compatibility... chapter 22 presents a syntactic grammar
     * <p>
     * Выходные данные:
     * 22
     */
    public static void main(String[] args) {
        System.out.println("Введите количество слов:");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println("Введите строку:");
        Scanner scanner1 = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            String string = scanner1.next();
            if (isNumber(string) && isPalindrome(string)) {
                if (list.size() == 2) {
                    break;
                } else if (list.contains(string)) {
                    continue;
                }
                list.add(string);
            }
        }
        if (list.isEmpty()) {
            System.out.println("NOT FOUND");
        } else if (list.size() == 1) {
            System.out.println(list.get(0));
        } else {
            System.out.println(list.get(1));
        }


    }
}
