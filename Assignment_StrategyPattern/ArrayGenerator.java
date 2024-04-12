package Assignment_StrategyPattern;

import java.util.Random;

public class ArrayGenerator {

    Random random = new Random();
    int[] arr;

    public ArrayGenerator(int n) {
        this.arr = new int[n];
    }

    public int[] getArr() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(30);
        }
        return arr;
    }
}
