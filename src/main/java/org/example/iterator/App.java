package org.example.iterator;

import java.util.Iterator;

public class App {
    public static void main(String[] args) {
        FibonacciSequence fibSequence = new FibonacciSequence();
        Iterator<Integer> fibIterator = fibSequence.iterator();

        int count = 0;
        while (fibIterator.hasNext() && count < 10) {
            System.out.println(fibIterator.next());
            count++;
        }
    }
}