package com.epam.homework.task23;

import java.util.HashSet;
import java.util.Set;

public class Task23Impl implements Task23 {
    @Override
    public Set<Integer> intersection(Set<Integer> first, Set<Integer> second) {
        Set<Integer> result = new HashSet<>();
        for (Integer element : first) {
            if (second.contains(element)) {
                result.add(element);
            }
        }
        return result;
    }

    @Override
    public Set<Integer> union(Set<Integer> first, Set<Integer> second) {
        Set<Integer> result = new HashSet<>();
        result.addAll(first);
        result.addAll(second);
        return result;
    }
}