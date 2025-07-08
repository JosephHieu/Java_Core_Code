public class Main {

    public static long power(int n) {
        if (n == 0) return 1;
        return power(n - 1) * 2;
    }

    static int Riddle(int[] a, int n) {
        if (n == 1) return a[0];
        int temp = Riddle(a, n - 1);
        return (temp <= a[n - 1]) ? temp :  a[n - 1];
    }

    public static int exp(int x, int n) {
        int s = 1;
        for (int i = 1; i <= n; i++) {
            int p = 1;
            for (int j = 1; j <= i; j++) {
                p *= (int)((double)x / j);
            }
            s += p;
        }
        return s;
    }

    public static int exp2(int x, int n) {

        int s = 1;
        int p = 1;
        for (int i = 1; i <= n; i++) {
            p *= (int) ((double) x / i);
            s += p;
        }
        return s;
    }

    public static int BruteForceStringMatch(String T, String P) {
        int n = T.length();  // Độ dài chuỗi văn bản
        int m = P.length();  // Độ dài mẫu cần tìm

        System.out.println("Chuỗi T: " + T);
        System.out.println("Chuỗi P: " + P);

        // Duyệt từng vị trí i trong chuỗi T
        for (int i = 0; i <= n - m; i++) {
            System.out.println("\nĐang kiểm tra tại vị trí i = " + i);

            int j = 0;  // Biến đếm số ký tự trùng khớp

            // So sánh từng ký tự trong P với T[i..i+m-1]
            while (j < m && P.charAt(j) == T.charAt(i + j)) {
                System.out.println("  P[" + j + "] = '" + P.charAt(j) + "' == T[" + (i + j) + "] = '" + T.charAt(i + j) + "'");
                j++;
            }

            // Nếu toàn bộ P khớp với một đoạn trong T, trả về vị trí
            if (j == m) {
                System.out.println(" Tìm thấy mẫu P tại vị trí " + i);
                return i;
            }
        }

        System.out.println(" Không tìm thấy mẫu P trong T.");
        return -1;  // Không tìm thấy
    }

    public static void selectionSort(int[] arr) {

        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[i]) {
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }

    public static int BruteForceStringMatch2(String T, String P) {

        int n = T.length();
        int m = P.length();
        for (int i = 0; i <= n - m; i++) {
            int j = 0;
            while (j < m && (P.charAt(0) == T.charAt(i + j))) {
                j = j + 1;
            }
            if (j == m) return i;
        }
        return -1;
    }

    public static void main(String[] args) {

//        System.out.println(exp(4, 5));
//        System.out.println(exp2(4, 5));

        int[] a = {9, 3, 23, 8, 1};
//        selectionSort(a);
//        System.out.println(Arrays.toString(a));
//
//        BruteForceStringMatch("hieu", "eu");
        // System.out.println(Riddle(a, 5));

        // System.out.println(BruteForceStringMatch2("NguyenHoangHieu", "Huy"));
        System.out.println("Nguyễn Hoàng Hiếu");

    }







}