package QuyHoachDong.LIS;

// Dãy con tăng dài nhất - Longest Increasing Subsequence

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int n = 10;
        int[] arr = new int[n];
        int[] L = new int[n];
        Arrays.fill(L, 1);

        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * 10);
        }

        System.out.println(Arrays.toString(arr));

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    L[i] = Math.max(L[i], L[j] + 1);
                }
            }
        }

        Arrays.stream(L)
                .max()
                .ifPresent(s -> System.out.println("Dãy con dài nhất là " + s));
    }
}
