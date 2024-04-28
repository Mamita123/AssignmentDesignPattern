package org.example.iterator;

import java.util.Iterator;

public class FibonacciIterator implements Iterator<Integer> {
    private int current = 1;
    private int previous = 0;

    @Override
    public boolean hasNext() {
        // This method can be modified to stop at a certain condition if needed
        return true; // This example assumes an infinite sequence
    }

    @Override
    public Integer next() {
        int next = current + previous;
        previous = current;
        current = next;
        return previous;
    }
}
