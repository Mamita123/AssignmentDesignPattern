package Assignment_StrategyPattern;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SortingContext sorting = new SortingContext();
        System.out.println("Enter the Array Size for sorting:");
        Scanner scanner = new Scanner(System.in);
        int arraySize = scanner.nextInt();
        System.out.println("Array with " + arraySize + " elements:");
        while (arraySize != 0) {
            for (int i = 1; i <= 3; i++) {
                switch (i) {
                    case 1:
                        sorting.setSortingAlgorithms(new HeapSort());
                        break;
                    case 2:
                        sorting.setSortingAlgorithms(new SelectionSort());
                        break;
                    case 3:
                        sorting.setSortingAlgorithms(new InsertionSort());
                        break;
                    default:
                        break;
                }
                sorting.algorithmSorting(new ArrayGenerator(arraySize).getArr(), new Timer());
                System.out.println();
            }
            System.out.println(">>Enter Array Size or 0 to quit: ");
            arraySize = scanner.nextInt();
        }

        System.out.println("Program Ended!");

    }
}
