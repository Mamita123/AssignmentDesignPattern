package Assignment_StrategyPattern;

public class SortingContext {

    private SortingAlgorithms sortingAlgorithms;

    // public SortingContext(SortingAlgorithms sortingAlgorithms){
    // this.sortingAlgorithms = sortingAlgorithms;
    // }

    public void setSortingAlgorithms(SortingAlgorithms sortingAlgorithms) {
        this.sortingAlgorithms = sortingAlgorithms;
    }

    public void sort(int[] arr) {
        sortingAlgorithms.sort(arr);
    }

    /*
     * static void printArray(int[] arr)
     * {
     * int N = arr.length;
     * 
     * for (int i = 0; i < N; ++i)
     * System.out.print(arr[i] + " ");
     * System.out.println();
     * }
     */

    public void algorithmSorting(int[] arr, Timer timer) {
        timer.start();
        sort(arr);
        timer.stopRunning();
        System.out.println(sortingAlgorithms.getName() + " Time: " + timer.getTime() + " ms");
    }
}
