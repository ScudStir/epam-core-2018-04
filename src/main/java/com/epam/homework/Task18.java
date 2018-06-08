package com.epam.homework;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Task18 {

    /**
     * Найти максимальный элемент(ы) в матрице и удалить из матрицы все строки и столбцы, его содержащие.
     * Гарантируется что после удаления в матрице останется хотя бы один элемент.
     * <a href="https://github.com/elefus/epam-core-04-2018/wiki/Представление-матриц">Представление матриц</a>
     * <p>
     * Формат входных данных:
     * N - целое число (0 < N < 10)
     * N ^ 2 целых чисел (Integer.MIN_VALUE < element < Integer.MAX_VALUE)
     * <p>
     * Формат выходных данных:
     * В результате выполнения задания в выходной поток должна быть выведена преобразованная матрица.
     * Так как матрица в результате преобразования может перестать быть квадратной - несколько изменяется формат её представления:
     * N (целое число) - количество строк
     * M (целое число) - количество столбцов
     * N * M целых чисел, являющихся элементами матрицы
     * <p>
     * ---------------------------------------------------------------------------------------------------
     * Примеры выполнения задания:
     * <p>
     * Входные данные:
     * 3
     * 2  1 -3
     * -2  3  2
     * -1  0  0
     * <p>
     * Выходные данные:
     * 2
     * 2
     * 2 -3
     * -1  0
     * <p>
     * <p>
     * <p>
     * Входные данные:
     * 4
     * 3 -2 -4  1
     * 1  4  4  2
     * -1  0 -3  1
     * 0  2  1  3
     * <p>
     * Выходные данные:
     * 3
     * 2
     * 3  1
     * -1  1
     * 0  3
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = readMatrix(scanner);

        Set<Integer> rows = new HashSet<>();
        Set<Integer> columns = new HashSet<>();

        SetThePositionsOfTheRowsAndColumnsToBeRemoved(rows, columns, matrix);

        int[][] shiftedMatrix = getShiftedMatrixWithoutRowsAndColumns(rows, columns, matrix);

        System.out.println(shiftedMatrix.length);
        System.out.println(shiftedMatrix[0].length);
        printMatrix(shiftedMatrix);
    }

    private static int[][] readMatrix(Scanner scanner) {
        int dimension = scanner.nextInt();
        int[][] matrix = new int[dimension][dimension];
        for (int row = 0; row < dimension; row++) {
            for (int col = 0; col < dimension; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }
        return matrix;
    }

    private static int getMaxValue(int[][] matrix) {
        int maxCurrentValue = matrix[0][0];
        for (int[] row : matrix) {
            for (int i = 0; i < matrix.length; i++) {
                maxCurrentValue = Math.max(row[i], maxCurrentValue);
            }
        }
        return maxCurrentValue;
    }

    private static void SetThePositionsOfTheRowsAndColumnsToBeRemoved(Set<Integer> rows,
                                                                      Set<Integer> columns,
                                                                      int[][] matrix) {
        int maxValue = getMaxValue(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == maxValue) {
                    rows.add(i);
                    columns.add(j);
                }
            }
        }
    }

    private static int[][] getShiftedMatrixWithoutRowsAndColumns(Set<Integer> removingRows,
                                                                 Set<Integer> removingColumns,
                                                                 int[][] oldMatrix) {

        int[][] newMatrix = new int[oldMatrix.length - removingRows.size()][oldMatrix.length - removingColumns.size()];

        int rowsOffset = 0;
        for (int i = 0; i < oldMatrix.length; i++) {
            int columnsOffset = 0;
            if (removingRows.contains(i)) {
                rowsOffset++;
            } else {
                for (int j = 0; j < oldMatrix[0].length; j++) {
                    if (removingColumns.contains(j)) {
                        columnsOffset++;
                    } else {
                        newMatrix[i - rowsOffset][j - columnsOffset] = oldMatrix[i][j];
                    }
                }
            }

        }
        return newMatrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(row[j] + " ");
            }
            System.out.println();
        }
    }
}
