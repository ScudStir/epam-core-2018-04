package com.scudstir.tasks.Task23;

import java.util.Set;

public interface Task23 {

    /**
     * Операция пересечения целочисленных множеств.
     * @param first Первое множество.
     * @param second Второе множество.
     * @return Результат пересечения множеств.
     */
    Set<Integer> intersection(Set<Integer> first, Set<Integer> second);

    /**
     * Операция объединения целочисленных множеств.
     * @param first Первое множество.
     * @param second Второе множество.
     * @return Результат объединения множеств.
     */
    Set<Integer> union(Set<Integer> first, Set<Integer> second);
}
