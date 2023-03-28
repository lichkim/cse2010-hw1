package cse2010.hw1;

public class InsertionSort {

    /**
     * Sort an array xs in a non-increasing (i.e., decreasing) order
     * @param xs integer array
     */
    // DO NOT MODIFY THIS METHOD!!
    public static void isort(int[] xs) {
        for (int i = 1; i < xs.length; i++) {
            insert(xs, i);
        }
    }

    /**
     * Insert element xs[k] to already sorted group x[0]..x[k-1]
     * @param xs integer array
     * @param k index of element to be inserted
     */
    private static void insert(int[] xs, int k) {
        /*
            Complete code here. You must call `swap()` method.
         */
        //xs[0]...xs[k-1]까지는 이미 정렬되어 있으므로
        //xs[i(from k)] <= xs[i-1]이 될 때 까지 xs[i]와 xs[i-1]을 swap한다
        int i = k;
        while (i > 0 && xs[i] > xs[i - 1]){
            swap(xs, i, i - 1);
            i--;
        }
    }

    /**
     * Swap elements at position i and j in array xs
     * @param xs integer array
     * @param i index of element to be swapped
     * @param j index of element to be swapped
     */
    private static void swap(int[] xs, int i, int j) {
        /*
            Complete code here.
         */

        int temp = xs[i];
        xs[i] = xs[j];
        xs[j] = temp;
    }
}
