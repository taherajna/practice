package com.taherajna.practice.datastructures;

import java.util.Iterator;
import java.util.LinkedHashSet;
import org.junit.Test;

public class HashSet {
    @Test
    public void name() {
        LinkedHashSet<Integer> integerSet = new LinkedHashSet<>();
        integerSet.add(2);
        integerSet.add(5);
        integerSet.add(3);
        integerSet.add(4);
        integerSet.add(5);
        integerSet.contains(5);
        Iterator<Integer> iterator = integerSet.iterator();
        iterator.next();
        iterator.remove();
        integerSet.add(5);
    }
}
