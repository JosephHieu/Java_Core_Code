package sortingAlgorithm;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {

        int[] a = {5, 6, 2, 2, 10, 12, 9, 10, 9, 3};

        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(a));
    }

}
