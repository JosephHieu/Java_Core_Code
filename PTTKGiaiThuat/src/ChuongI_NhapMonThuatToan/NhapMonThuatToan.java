package ChuongI_NhapMonThuatToan;

import java.util.Arrays;

public class NhapMonThuatToan {

    public static void InsertionSort(int[] a) {
        for (int j = 1; j < a.length; j++) {
            int key = a[j];
            int i = j - 1;
            while (i >= 0 && a[i] > key) {
                a[i + 1] = a[i];
                i--;
            } 
            a[i + 1] = key;
        }
    }

    public static void main (String[] args) {
        int[] a = {9, 13, 43, 1, 9, 4, 6};
        InsertionSort(a);
        System.out.println(Arrays.toString(a));
    }
}
