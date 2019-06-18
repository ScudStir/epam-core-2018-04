package com.scudstir.tasks;

import java.util.Scanner;

public class Task6 {

    /**
     * Ввести N слов с консоли.
     * Найти слово, буквы в котором идут в строгом порядке возрастания их кодов: word.charAt(i) < word.charAt(i + 1).
     * Если таких слов несколько, найти первое из них.
     * Слова состоящие из одного символа не учитывать.
     * <p>
     * Формат входных данных:
     * N (целое число, 0 < N < 100) - количество слов в строке
     * Строка, содержащая нимимум N слов, разделенных пробелами
     * <p>
     * Формат выходных данных:
     * В результате выполнения в выходной поток должно быть выведено слово, удовлетворяющее условию.
     * Если подходящее слово не найдено в выходной поток выводится строка "NOT FOUND"
     * <p>
     * ---------------------------------------------------------------------------------------------------
     * Примеры выполнения задания:
     * <p>
     * Входные данные:
     * 12
     * The original and reference implementation Java compilers were originally released by Sun
     * <p>
     * Выходные данные:
     * by
     * <p>
     * ===================================================================================================
     * <p>
     * Входные данные:
     * 4
     * Кто-то позвонил в дверь
     * <p>
     * Выходные данные:
     * NOT FOUND
     */
    private static boolean searchWord(String string) {
        char[] chars = string.toCharArray();
        for (int y = 1; y < chars.length; y++) {
            if (chars[y] <= chars[y - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Введите количество слов:");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println("Введите строку:");
        Scanner scanner1 = new Scanner(System.in);
        String result = "";
        for (int i = 0; i < num; i++) {
            String string = scanner1.next();
            if (searchWord(string)) {
                result = string;
                break;
            }
        }
        if (!result.isEmpty()) {
            System.out.println(result);
        } else {
            System.out.println("NOT FOUND");

        }

    }

}


