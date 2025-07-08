package QuayLuiNhanhCan.QuayLui;

public class PermutationBackTracking {

    private static int[] p;
    private static boolean[] used;
    private static int n, k;

    private static void KPermutationBackTracking(int i) {

        for (int j = 1; j <= n; j++) {
            if (used[j]) {     // Nếu j chưa dùng
                p[i] = j;      // Chọn j cho vị trí i
                used[j] = false;  // Đánh dấu j đã dùng

                if (i == k) {
                    printResult();   // Đã đử k phần tử -> in ra
                } else {
                    KPermutationBackTracking(i + 1); // Gọi đệ quy để chọn tiếp
                }

                used[j] = true;   // Quay lui: bỏ chọn j
            }
        }
    }

    private static void printResult() {
        for (int i = 1; i <= k; i++) {
            System.out.print(p[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {

        n = 4;
        k = 3;

        p = new int[k + 1];
        used = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            used[i] = true;
        }

        KPermutationBackTracking(1);
    }
}
