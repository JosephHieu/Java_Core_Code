package QuayLuiNhanhCan.QuayLui;

public class BinaryBackTracking {

    private static void BinaryBackTracking(int[] b, int k, int n) {

        for (int j = 0; j <= 1; j++) {
            b[k] = j;
            if (k == n) {
                for (int i = 1; i <= n; i++) {
                    System.out.print(b[i]);
                }
                System.out.println();
            } else {
                BinaryBackTracking(b, k + 1, n);
            }
        }
    }

    public static void main(String[] args) {

        int n = 3;
        int[] b = new int[n + 1];
        BinaryBackTracking(b, 1, n);
    }
}
